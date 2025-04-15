import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        // 1. 수식에 등장하는 최대 숫자를 찾아 가능한 진법 범위 좁히기
        int maxDigit = 0;
        for (String expr : expressions) {
            String[] parts = expr.split(" ");
            maxDigit = Math.max(maxDigit, getMaxDigit(parts[0]));
            maxDigit = Math.max(maxDigit, getMaxDigit(parts[2]));
            if (!parts[4].equals("X")) {
                maxDigit = Math.max(maxDigit, getMaxDigit(parts[4]));
            }
        }
        
        // 최소 진법은 최대 숫자 + 1
        int minBase = maxDigit + 1;
        
        // 2. 가능한 진법 찾기
        List<Integer> validBases = new ArrayList<>();
        for (int base = minBase; base <= 9; base++) {
            boolean valid = true;
            for (String expr : expressions) {
                String[] parts = expr.split(" ");
                String A = parts[0], op = parts[1], B = parts[2], C = parts[4];
                
                if (!C.equals("X")) {
                    int a = convertToDecimal(A, base);
                    int b = convertToDecimal(B, base);
                    int c = convertToDecimal(C, base);
                    
                    int expected = op.equals("+") ? a + b : a - b;
                    if (expected != c) {
                        valid = false;
                        break;
                    }
                }
            }
            if (valid) {
                validBases.add(base);
            }
        }
        
        // 3. X 값 채우기
        List<String> result = new ArrayList<>();
        for (String expr : expressions) {
            String[] parts = expr.split(" ");
            String A = parts[0], op = parts[1], B = parts[2], C = parts[4];
            
            if (C.equals("X")) {
                Map<String, Integer> resultCounts = new HashMap<>();
                
                for (int base : validBases) {
                    int a = convertToDecimal(A, base);
                    int b = convertToDecimal(B, base);
                    
                    int calc = op.equals("+") ? a + b : a - b;
                    String resultStr = convertFromDecimal(calc, base);
                    resultCounts.put(resultStr, resultCounts.getOrDefault(resultStr, 0) + 1);
                }
                
                // 모든 진법에서 같은 결과가 나오면 그 값을, 아니면 ?
                if (resultCounts.size() == 1) {
                    String answer = resultCounts.keySet().iterator().next();
                    result.add(A + " " + op + " " + B + " = " + answer);
                } else {
                    result.add(A + " " + op + " " + B + " = ?");
                }
            }
        }
        
        return result.toArray(new String[0]);
    }
    
    // 문자열에서 가장 큰 숫자(디지트) 찾기
    private int getMaxDigit(String s) {
        int max = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                max = Math.max(max, c - '0');
            }
        }
        return max;
    }
    
    // base진법 문자열을 10진수로 변환
    private int convertToDecimal(String s, int base) {
        int result = 0;
        for (char c : s.toCharArray()) {
            int digit = c - '0';
            result = result * base + digit;
        }
        return result;
    }
    
    // 10진수를 base진법 문자열로 변환
    private String convertFromDecimal(int num, int base) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.insert(0, num % base);
            num /= base;
        }
        return sb.toString();
    }
}
