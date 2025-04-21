class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0; // cards1의 현재 위치
        int index2 = 0; // cards2의 현재 위치
        
        // goal의 각 단어를 순서대로 확인
        for (String targetWord : goal) {
            // cards1에서 현재 위치의 카드가 목표 단어와 일치하는지 확인
            if (index1 < cards1.length && targetWord.equals(cards1[index1])) {
                index1++;
            } 
            // cards2에서 현재 위치의 카드가 목표 단어와 일치하는지 확인
            else if (index2 < cards2.length && targetWord.equals(cards2[index2])) {
                index2++;
            } 
            // 두 카드 뭉치 모두에서 현재 단어를 찾을 수 없는 경우
            else {
                return "No";
            }
        }
        
        // 모든 목표 단어를 찾았으면 성공
        return "Yes";
    }
}
