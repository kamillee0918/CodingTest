import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 1. 인접 리스트로 양방향 그래프 구성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        // 2. 목적지에서 시작하는 BFS로 모든 노드까지의 거리를 계산
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);  // -1은 도달할 수 없음
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        distance[destination] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph.get(current)) {
                if (distance[next] == -1) {     // 아직 방문하지 노드라면
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                    
                }
            }
        }
        
        // 3. 각 출발점의 거리를 결과 배열에 저장
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }
        
        return answer;
    }
}