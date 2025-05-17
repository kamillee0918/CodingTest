class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int[][] computers, boolean[] visited, int node) {
        visited[node] = true;
        
        for (int neighbor = 0; neighbor < computers.length; neighbor++) {
            if (computers[node][neighbor] == 1 && !visited[neighbor]) {
                dfs(computers, visited, neighbor);
            }
        }
    }
}