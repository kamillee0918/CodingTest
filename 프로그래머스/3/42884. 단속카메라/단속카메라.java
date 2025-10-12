import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        // 진출 지점으로 오름차순 정렬
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int answer = 1;             // 최소 한 대의 카메라는 필요
        int camera = routes[0][1];  // 첫 번째 차량의 진출 지점에 카메라를 설치
        
        for (int i = 1; i < routes.length; i++) {
            /*
            현재 차량의 진입 지점이 카메라 위치보다 크면
            기존 카메라로는 단속할 수 없음
            */
            if (routes[i][0] > camera) {
                answer++;
                camera = routes[i][1];  // 새 카메라를 진출 지점에 설치
            }
        }
        
        return answer;
    }
}