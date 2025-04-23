class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        boolean[] skipChars = new boolean[26]; // 건너뛸 문자 표시
        
        // skip에 포함된 문자 표시
        for (char c : skip.toCharArray()) {
            skipChars[c - 'a'] = true;
        }
        
        // 각 문자 처리
        for (char c : s.toCharArray()) {
            char nextChar = shiftChar(c, skipChars, index);
            answer.append(nextChar);
        }
        
        return answer.toString();
    }
    
    // 주어진 문자를 index만큼 이동하는 함수
    private char shiftChar(char c, boolean[] skipChars, int index) {
        int count = 0;
        while (count < index) {
            // 다음 알파벳으로 이동 (z 다음은 a)
            c = (char)((c - 'a' + 1) % 26 + 'a');
            
            // skip에 없는 문자만 카운트
            if (!skipChars[c - 'a']) {
                count++;
            }
        }
        return c;
    }
}
