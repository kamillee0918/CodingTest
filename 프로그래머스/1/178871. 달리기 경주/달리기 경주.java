import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerToPosition = new HashMap<>();
        
        // 초기 위치 설정
        for (int i = 0; i < players.length; i++) {
            playerToPosition.put(players[i], i);
        }
        
        // 각 호출 처리
        for (String calledPlayer : callings) {
            // 호출된 선수의 현재 위치
            int currentPos = playerToPosition.get(calledPlayer);
            
            // 앞 선수 찾기
            String frontPlayer = players[currentPos - 1];
            
            // 위치 교환 (players 배열)
            players[currentPos - 1] = calledPlayer;
            players[currentPos] = frontPlayer;
            
            // 위치 정보 업데이트 (HashMap)
            playerToPosition.put(calledPlayer, currentPos - 1);
            playerToPosition.put(frontPlayer, currentPos);
        }
        
        return players;
    }
}
