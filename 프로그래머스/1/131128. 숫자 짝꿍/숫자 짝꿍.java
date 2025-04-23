class Solution {
    public String solution(String X, String Y) {
        // 각 숫자의 빈도수 카운팅
        int[] freqX = new int[10];
        int[] freqY = new int[10];
        
        // X의 각 자릿수 빈도 계산
        for (char c : X.toCharArray()) {
            freqX[c - '0']++;
        }
        
        // Y의 각 자릿수 빈도 계산
        for (char c : Y.toCharArray()) {
            freqY[c - '0']++;
        }
        
        // 결과 문자열 구성
        StringBuilder sb = new StringBuilder();
        
        // 9부터 0까지 내림차순으로 숫자 추가 (가장 큰 수 만들기)
        for (int i = 9; i >= 0; i--) {
            int commonCount = Math.min(freqX[i], freqY[i]);
            for (int j = 0; j < commonCount; j++) {
                sb.append(i);
            }
        }
        
        // 특수 케이스 처리
        if (sb.length() == 0) {
            return "-1";  // 공통 숫자가 없는 경우
        }
        
        // 결과가 0으로 시작하면 모든 공통 숫자가 0임
        if (sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}
