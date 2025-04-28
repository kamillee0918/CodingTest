class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
            int ballX = balls[i][0];
            int ballY = balls[i][1];
            
            // 가능한 최소 거리 (초기값은 최대로 설정)
            int minDistance = Integer.MAX_VALUE;
            
            // 왼쪽 벽에 대한 반사 (x = 0)
            // 단, 시작점과 목표 공이 수평선상에 있고 시작점이 목표 공 오른쪽에 있으면 제외
            if (!(startY == ballY && startX > ballX)) {
                int reflectionX = -ballX;
                int reflectionY = ballY;
                int distance = (startX - reflectionX) * (startX - reflectionX) + 
                               (startY - reflectionY) * (startY - reflectionY);
                minDistance = Math.min(minDistance, distance);
            }
            
            // 오른쪽 벽에 대한 반사 (x = m)
            if (!(startY == ballY && startX < ballX)) {
                int reflectionX = 2 * m - ballX;
                int reflectionY = ballY;
                int distance = (startX - reflectionX) * (startX - reflectionX) + 
                               (startY - reflectionY) * (startY - reflectionY);
                minDistance = Math.min(minDistance, distance);
            }
            
            // 아래쪽 벽에 대한 반사 (y = 0)
            if (!(startX == ballX && startY > ballY)) {
                int reflectionX = ballX;
                int reflectionY = -ballY;
                int distance = (startX - reflectionX) * (startX - reflectionX) + 
                               (startY - reflectionY) * (startY - reflectionY);
                minDistance = Math.min(minDistance, distance);
            }
            
            // 위쪽 벽에 대한 반사 (y = n)
            if (!(startX == ballX && startY < ballY)) {
                int reflectionX = ballX;
                int reflectionY = 2 * n - ballY;
                int distance = (startX - reflectionX) * (startX - reflectionX) + 
                               (startY - reflectionY) * (startY - reflectionY);
                minDistance = Math.min(minDistance, distance);
            }
            
            answer[i] = minDistance;
        }
        
        return answer;
    }
}
