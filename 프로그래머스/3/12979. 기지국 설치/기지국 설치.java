class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int coverage = w * 2 + 1;   // 하나의 기지국이 커버할 수 있는 아파트의 수
        int idx = 0;                // stations 배열에서 현재 사용할 기지국의 인덱스
        int position = 1;           // 현재 전파가 닿지 않은 아파트의 번호(1번부터 시작)
        
        while (position <= n) {
            // 현재 위치가 기존 기지국 커버 범위 안에 있으면, 다음 커버 범위로 이동함
            if (idx < stations.length && position >= stations[idx] - w) {
                // 해당 기지국이 커버하는 가장 오른쪽 아파트의 다음으로 이동함
                position = stations[idx] + w + 1;
                idx++;              // 다음 기지국으로 인덱스를 이동
            } else {
                // 커버 가능한 범위를 한 번에 커버하도록 최대한 오른쪽 끝까지 이동하여 기지국을 설치함
                answer++;
                position += coverage;
            }
        }
        
        return answer;
    }
}