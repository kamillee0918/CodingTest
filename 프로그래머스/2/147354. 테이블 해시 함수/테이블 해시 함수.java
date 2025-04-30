import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // 1. 정렬 시작
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] == b[col - 1]) {
                // 만약 같은 값이라면 첫 번째 컬럼을 내림차순으로 정렬
                return b[0] - a[0];
            }
            // col번째 컬럼을 오름차순으로 정렬
            return a[col - 1] - b[col - 1];
        });
        
        // 2. S_i 계산 및 XOR 누적
        int result = 0;
        for (int i = row_begin; i <= row_end; i++) {
            int rowSum = 0;
            // 행의 각 값을 i로 나눈 나머지의 합을 계산
            for (int value : data[i - 1]) {
                rowSum += value % i;
            }
            // 이후 XOR 연산으로 누적
            result ^= rowSum;
        }
        
        return result;
    }
}