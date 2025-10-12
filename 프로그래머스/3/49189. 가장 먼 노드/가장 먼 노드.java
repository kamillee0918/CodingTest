import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 1. 인접 리스트로 그래프 구성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 양방향 간선 추가
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        // 2. BFS를 위한 준비
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);  // -1은 미방문을 의미
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        distance[1] = 0;  // 시작 노드의 거리는 0
        
        // 3. BFS 수행
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            // 현재 노드와 연결된 모든 노드 확인
            for (int next : graph.get(current)) {
                if (distance[next] == -1) {  // 아직 방문하지 않은 노드
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }
        
        // 4. 최댓값(가장 먼 거리) 찾기
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, distance[i]);
        }
        
        // 5. 최댓값과 같은 노드의 개수 세기
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == maxDistance) {
                answer++;
            }
        }
        
        return answer;
    }
}