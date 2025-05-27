class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1000000007;
        
        // DP 테이블 생성 (1-based 인덱스 사용)
        int[][] dp = new int[n + 1][m + 1];
        
        // 물웅덩이 표시
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for (int[] puddle : puddles) {
            isPuddle[puddle[1]][puddle[0]] = true;
        }
        
        // 시작점 초기화
        dp[1][1] = 1;
        
        // DP 테이블 채우기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 시작점이거나 물웅덩이면 스킵
                if ((i == 1 && j == 1) || isPuddle[i][j]) {
                    continue;
                }
                
                // 위쪽에서 오는 경로
                if (i > 1 && !isPuddle[i - 1][j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                }
                
                // 왼쪽에서 오는 경로
                if (j > 1 && !isPuddle[i][j - 1]) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                }
            }
        }
        
        return dp[n][m];
    }
}
