import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int currentHealth = health;
        int lastAttackTime = attacks[attacks.length - 1][0];
        int attackIndex = 0;
        int healing = 0;
        
        for (int time = 1; time <= lastAttackTime; time++) {
            // 공격 시간인 경우에는
            if (attackIndex < attacks.length && time == attacks[attackIndex][0]) {
                currentHealth -= attacks[attackIndex][1];
                attackIndex++;
                healing = 0;
                
                if (currentHealth <= 0) {
                    return -1;
                }
            }
            // 회복을 하는 경우에는
            else {
                currentHealth += bandage[1];
                healing++;
                
                if (healing == bandage[0]) {
                    currentHealth += bandage[2];
                    healing = 0;
                }
                
                if (currentHealth > maxHealth) {
                    currentHealth = maxHealth;
                }
            }
        }
        
        return currentHealth;
    }
}