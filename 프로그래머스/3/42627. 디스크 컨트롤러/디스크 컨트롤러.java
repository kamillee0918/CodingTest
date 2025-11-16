import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 1. jobs를 요청시간 기준 오름차순 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // 2. 우선순위 큐: 작업 소요시간이 적은 순서대로(작업 [요청시점, 소요시간])
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        // 3. 시간, 처리된 작업 수, 정답 누적 변수
        int time = 0;
        int idx = 0;
        int count = 0;
        int total = 0;
        
        // 전체 작업 처리
        while (count < jobs.length) {
            // 현재 시간까지 요청된 모든 작업 pq에 넣기
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(jobs[idx]);
                idx++;
            }
            // 우선순위 작업 꺼내 처리
            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                // 작업 요청 시간보다 현재 시간이 느리면 바로 시작, 아니면 요청시각까지 대기
                time = Math.max(time, job[0]) + job[1];
                // 종료시각 - 요청시각 = 반환시간
                total += (time - job[0]);
                count++;
            } else {
                // 처리할 수 있는 작업이 없으면 시간 한 칸 증가
                time = jobs[idx][0];
            }
        }
        // 평균 반환시간(정수 부분만)
        return total / jobs.length;
    }
}