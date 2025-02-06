class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int left = 0;
        int currentSum = 0;
        int min_length = Integer.MAX_VALUE;
        int result_left = -1;
        int result_right = -1;

        for (int right = 0; right < n; right++) {
            currentSum += sequence[right];

            while (left <= right && currentSum > k) {
                currentSum -= sequence[left];
                left++;
            }

            if (currentSum == k) {
                int windowLength = right - left + 1;
                if (windowLength < min_length || 
                    (windowLength == min_length && left < result_left)) {
                    min_length = windowLength;
                    result_left = left;
                    result_right = right;
                }
            }
        }

        return new int[]{result_left, result_right};
    }
}
