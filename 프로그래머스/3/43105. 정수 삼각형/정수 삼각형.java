class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int[][] dp = new int[height][height];
        
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                int left = (j > 0) ? dp[i - 1][j - 1] : 0;
                int right = (j < i) ? dp[i - 1] [j] : 0;
                dp[i][j] = Math.max(left, right) + triangle[i][j];
            }
        }
        
        int max = 0;
        for (int num : dp[height - 1]) {
            max = Math.max(max, num);
        }
        
        return max;
    }
}