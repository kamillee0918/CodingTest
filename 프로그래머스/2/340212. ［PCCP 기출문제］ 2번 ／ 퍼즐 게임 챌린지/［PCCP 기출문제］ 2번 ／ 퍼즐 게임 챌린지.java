class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (checkSolvePuzzles(diffs, times, limit, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean checkSolvePuzzles(int[] diffs, int[] times, long limit, int level) {
        long totalTime = 0;
        int prevTime = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                totalTime += times[i];
            } else {
                long failures = diffs[i] - level;
                totalTime += failures * (times[i] + prevTime) + times[i];
            }
            
            if (totalTime > limit) {
                return false;
            }
            
            prevTime = times[i];
        }
        
        return true;
    }
}