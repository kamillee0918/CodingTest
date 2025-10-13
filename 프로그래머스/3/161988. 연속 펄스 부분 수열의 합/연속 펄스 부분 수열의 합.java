class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        
        // 두 가지 펄스 수열에 대한 누적합
        long sum1 = 0;  // 1로 시작하는 펄스
        long sum2 = 0;  // -1로 시작하는 펄스
        
        // 각 펄스의 누적합 최솟값
        long min1 = 0;
        long min2 = 0;
        
        long answer = Long.MIN_VALUE;
        int pulse = 1;
        
        for (int i = 0; i < n; i++) {
            // 펄스 적용한 누적합 계산
            sum1 += sequence[i] * pulse;
            sum2 += sequence[i] * (-pulse);
            
            // 현재까지의 최댓값 갱신
            // (현재 누적합 - 이전까지의 최소 누적합)
            answer = Math.max(answer, sum1 - min1);
            answer = Math.max(answer, sum2 - min2);
            
            // 최소 누적합 갱신 (최댓값 계산 후에 수행)
            min1 = Math.min(min1, sum1);
            min2 = Math.min(min2, sum2);
            
            // 펄스 부호 변경
            pulse *= -1;
        }
        
        return answer;
    }
}
