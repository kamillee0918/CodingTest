import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        // 1. 최댓값을 쉽게 찾기 위해 배열 정렬
        Arrays.sort(times);
        
        // 2. 이분 탐색 범위 설정
        long left = 1;  // 최소 시간
        long right = (long) times[times.length - 1] * n;  // 최대 시간
        long answer = right;
        
        // 3. 이분 탐색 수행
        while (left <= right) {
            long mid = (left + right) / 2;
            
            // 4. mid 시간 동안 처리 가능한 사람 수 계산
            long total = 0;
            for (int time : times) {
                total += mid / time;
                
                // 오버플로우 방지 및 조기 종료
                if (total >= n) {
                    break;
                }
            }
            
            // 5. 조건에 따라 범위 조정
            if (total >= n) {
                // n명 이상 처리 가능하면 시간을 줄여봄
                answer = mid;
                right = mid - 1;
            } else {
                // n명 미만이면 시간을 늘림
                left = mid + 1;
            }
        }
        
        return answer;
    }
}