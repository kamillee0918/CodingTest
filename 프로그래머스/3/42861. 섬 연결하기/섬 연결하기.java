import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 1. 비용 기준으로 정렬(가중치가 낮은 간선부터 선택함)
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        // 2. 서로소 집합(Disjoint Set)용 배열 선언 및 초기화
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        // 3. 모든 간선을 확인하며 MST 생성
        for(int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int value = cost[2];
            
            // 만약 아직 두 노드가 같은 집합이 아니라면, 사이클이 생기지 않으므로 연결
            if (findSet(parent, from) != findSet(parent, to)) {
                union(parent, from, to);
                answer += value; // 비용 누적
            }
        }
        
        return answer;
    }
    
    // 서로소 집합: 집합의 대표 노드(루트) 찾기
    private int findSet(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = findSet(parent, parent[x]); // 경로 압축
    }
    
    // 두 노드를 같은 집합(트리)로 합치기
    private void union(int[] parent, int a, int b) {
        int rootA = findSet(parent, a);
        int rootB = findSet(parent, b);
        if (rootA != rootB) {
            parent[rootB] = rootA; // root가 다를 때 한쪽에 합침
        }
    }
}