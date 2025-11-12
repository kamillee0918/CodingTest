class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        
        // 스티커가 한 장인 경우
        if (n == 1) {
            return sticker[0];
        }
        
        // 1. 첫 번째 스티커를 선택하는 경우(마지막 스티커는 못 고름)
        int[] dp1 = new int[n];
        dp1[0] = sticker[0];                        // 첫 번째 스티커를 선택
        dp1[1] = Math.max(sticker[0], sticker[1]);  // 두 스티커 중 큰 값을 선택
        
        for (int i = 2; i < n - 1; i++) {
            // i번째 스티커를 선택하면 `i-2`까지의 최대합 + sticker[i]
            // 선택하지 않으면 `i-1`까지의 최대합
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }
        
        // 2. 첫 번째 스티커를 선택하지 않는 경우(마지막 스티커는 선택할 수 있음)
        int[] dp2 = new int[n];
        dp2[0] = 0;             // 첫 번째 스티커 선택할 수 없음
        dp2[1] = sticker[1];    // 두 번째 스티커만 선택함
        
        for (int i = 2; i < n; i++) {
            // i번째 스티커를 선택하면 `i-2`까지의 최대합 + sticker[i]
            // 선택하지 않으면 `i-1`까지의 최대합
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }
        
        // 1번과 2번 경우 중 최대값이 정답임
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}