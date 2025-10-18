import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 1. HashMap으로 크기별 개수 저장
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int size : tangerine) {
            // getOrDefault: 키가 없으면 0 반환, 있으면 해당 값 반환
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        // 2. 빈도수를 리스트로 변환
        List<Integer> frequencyList = new ArrayList<>();
        for (int frequency : map.values()) {
            frequencyList.add(frequency);
        }
        
        // 3. 빈도수를 내림차순으로 정렬
        Collections.sort(frequencyList, Collections.reverseOrder());
        
        // 4. 그리디 선택: 개수가 많은 크기부터 선택
        int sum = 0;
        int answer = 0;
        
        for (int frequency : frequencyList) {
            answer++;           // 종류 증가
            sum += frequency;   // 귤 개수 누적
            
            if (sum >= k) {     // k개 이상 담으면 종료
                break;
            }
        }
        
        return answer;
    }
}