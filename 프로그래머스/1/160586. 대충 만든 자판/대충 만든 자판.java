import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 각 문자를 입력하기 위한 최소 키 누름 횟수를 저장하는 맵
        Map<Character, Integer> minPressMap = new HashMap<>();
        
        // 각 키맵을 순회하며 최소 키 누름 횟수 계산
        for (String keys : keymap) {
            for (int i = 0; i < keys.length(); i++) {
                char c = keys.charAt(i);
                int presses = i + 1; // 인덱스는 0부터 시작하므로 +1
                
                // 이미 등록된 문자라면 최소값 비교하여 갱신
                if (minPressMap.containsKey(c)) {
                    minPressMap.put(c, Math.min(minPressMap.get(c), presses));
                } else {
                    minPressMap.put(c, presses);
                }
            }
        }
        
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            int totalPresses = 0;
            boolean impossible = false;
            
            for (char c : targets[i].toCharArray()) {
                // 입력할 수 없는 문자가 있는 경우
                if (!minPressMap.containsKey(c)) {
                    impossible = true;
                    break;
                }
                totalPresses += minPressMap.get(c);
            }
            
            answer[i] = impossible ? -1 : totalPresses;
        }
        
        return answer;
    }
}
