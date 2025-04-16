import java.util.*;

class Solution {
    // 상하좌우 이동을 위한 배열
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        int n = land.length;      // 세로 길이
        int m = land[0].length;   // 가로 길이
        boolean[][] visited = new boolean[n][m]; // 방문 여부 체크
        int[] oilByColumn = new int[m]; // 각 열별 획득 가능한 석유량
        
        // 모든 좌표를 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 석유가 있고 아직 방문하지 않은 좌표라면
                if (land[i][j] == 1 && !visited[i][j]) {
                    // BFS로 해당 석유 덩어리를 탐색
                    bfs(land, visited, i, j, oilByColumn, n, m);
                }
            }
        }
        
        // 최대 석유량 찾기
        int maxOil = 0;
        for (int oil : oilByColumn) {
            maxOil = Math.max(maxOil, oil);
        }
        
        return maxOil;
    }
    
    // BFS로 석유 덩어리 탐색
    private void bfs(int[][] land, boolean[][] visited, int startX, int startY, int[] oilByColumn, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        // 덩어리 크기
        int size = 0;
        // 이 덩어리가 걸쳐있는 열을 표시하기 위한 배열
        boolean[] columns = new boolean[m];
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            size++; // 덩어리 크기 증가
            columns[y] = true; // 현재 열 표시
            
            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 범위 내에 있고, 석유가 있으며, 방문하지 않은 좌표라면
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && land[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        // 덩어리가 걸쳐있는 모든 열에 덩어리 크기 추가
        for (int j = 0; j < m; j++) {
            if (columns[j]) {
                oilByColumn[j] += size;
            }
        }
    }
}
