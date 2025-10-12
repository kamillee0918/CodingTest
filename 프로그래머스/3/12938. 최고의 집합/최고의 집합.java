class Solution {
    public int[] solution(int n, int s) {
        // s < n이면 자연수로 집합을 만들 수 없음
        if (s < n) {
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        int base = s / n;       // 기본값
        int remainder = s % n;  // 나머지
        
        // 배열을 기본값으로 채움
        for (int i = 0; i < n; i++) {
            answer[i] = base;
        }
        
        // 나머지를 뒤에서부터 1씩 더함 (오름차순 유지함)
        for (int i = n - remainder; i < n; i++) {
            answer[i]++;
        }
        
        return answer;
    }
}