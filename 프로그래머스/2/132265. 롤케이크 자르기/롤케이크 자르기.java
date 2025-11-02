import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        // 왼쪽 롤케이크에 있는 토핑의 종류를 저장할 Set
        Set<Integer> leftSet = new HashSet<>();
        // 오른쪽 롤케이크에 있는 토핑의 각 종류별 개수를 저장할 Map
        Map<Integer, Integer> rightMap = new HashMap<>();

        // 오른쪽 롤케이크에는 처음에 모든 토핑이 포함되므로, 
        // 토핑 배열을 순회하며 개수를 세어 보관한다.
        for (int top : topping) {
            rightMap.put(top, rightMap.getOrDefault(top, 0) + 1);
        }

        // 한 칸씩 왼쪽 롤케이크 쪽으로 이동하면서 토핑을 옮긴다.
        for (int top : topping) {
            // 왼쪽으로 토핑을 추가
            leftSet.add(top);

            // 오른쪽 토핑 개수를 하나 줄임
            rightMap.put(top, rightMap.get(top) - 1);

            // 오른쪽 토핑 개수가 0이면 Map에서 제거
            if (rightMap.get(top) == 0) {
                rightMap.remove(top);
            }

            // 왼쪽 롤케이크와 오른쪽 롤케이크의 토핑 종류 수가 같으면
            // 공평하게 나누어진 경우이므로 answer 증가
            if (leftSet.size() == rightMap.size()) {
                answer++;
            }
        }

        return answer;
    }
}