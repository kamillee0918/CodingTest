import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        // 최대 힙(내림차순으로) 생성
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int w : works) {
            queue.offer(w);
        }
        
        // n번 동안 가장 큰 작업량을 찾은 후 1씩 줄임
        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) {
                break;
            }
            int max = queue.poll();
            
            if (max > 0) {
                queue.offer(max - 1);
            } else {
                break; // 모두 0이면 줄일 필요 없음
            }
        }
        
        // 야근 피로도 계산
        long answer = 0;
        
        while (!queue.isEmpty()) {
            long w = queue.poll();
            answer += w * w;
        }
        
        return answer;
    }
}