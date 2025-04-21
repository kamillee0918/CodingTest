import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        // 사용 가능한 총 곡괭이 수
        int totalPicks = picks[0] + picks[1] + picks[2];
        
        // 캘 수 있는 최대 광물 수 (곡괭이 수 * 5개)
        int maxMinerals = Math.min(minerals.length, totalPicks * 5);
        
        // 그룹별 피로도 계산을 위한 리스트
        List<int[]> groups = new ArrayList<>();
        
        // 광물을 5개씩 그룹화하고 각 그룹의 피로도 계산
        for (int i = 0; i < maxMinerals; i += 5) {
            int diamondFatigue = 0;
            int ironFatigue = 0;
            int stoneFatigue = 0;
            
            // 현재 그룹의 광물 처리 (최대 5개)
            for (int j = i; j < Math.min(i + 5, maxMinerals); j++) {
                String mineral = minerals[j];
                
                if (mineral.equals("diamond")) {
                    diamondFatigue += 1;
                    ironFatigue += 5;
                    stoneFatigue += 25;
                } else if (mineral.equals("iron")) {
                    diamondFatigue += 1;
                    ironFatigue += 1;
                    stoneFatigue += 5;
                } else { // "stone"
                    diamondFatigue += 1;
                    ironFatigue += 1;
                    stoneFatigue += 1;
                }
            }
            
            // 현재 그룹의 피로도 정보 저장 [다이아, 철, 돌 곡괭이 사용 시 피로도]
            groups.add(new int[]{diamondFatigue, ironFatigue, stoneFatigue});
        }
        
        // 돌 곡괭이로 캤을 때 피로도 기준 내림차순 정렬
        Collections.sort(groups, (a, b) -> b[2] - a[2]);
        
        // 각 그룹에 최적의 곡괭이 할당하고 피로도 계산
        int totalFatigue = 0;
        
        for (int[] group : groups) {
            if (picks[0] > 0) {  // 다이아몬드 곡괭이 사용
                totalFatigue += group[0];
                picks[0]--;
            } else if (picks[1] > 0) {  // 철 곡괭이 사용
                totalFatigue += group[1];
                picks[1]--;
            } else if (picks[2] > 0) {  // 돌 곡괭이 사용
                totalFatigue += group[2];
                picks[2]--;
            } else {
                break;  // 더 이상 사용할 곡괭이가 없음
            }
        }
        
        return totalFatigue;
    }
}
