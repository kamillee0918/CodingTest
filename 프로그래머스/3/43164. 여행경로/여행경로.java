import java.util.*;

class Solution {
    private Map<String, PriorityQueue<String>> graph = new HashMap<>();
    private LinkedList<String> result = new LinkedList<>();
    
    public String[] solution(String[][] tickets) {
        // 1. 그래프 구성 (우선순위 큐로 자동 정렬)
        for (String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new PriorityQueue<>());
            graph.get(ticket[0]).add(ticket[1]);
        }
        
        // 2. DFS로 경로 탐색
        dfs("ICN");
        
        // 3. 역순으로 저장되므로 뒤집기
        return result.toArray(new String[0]);
    }
    
    private void dfs(String airport) {
        PriorityQueue<String> destinations = graph.get(airport);
        
        // 현재 공항에서 갈 수 있는 모든 목적지 탐색
        while (destinations != null && !destinations.isEmpty()) {
            dfs(destinations.poll());
        }
        
        // 모든 목적지를 방문한 후에 경로에 추가 (후위 순회)
        result.addFirst(airport);
    }
}