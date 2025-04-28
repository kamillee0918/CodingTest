class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        // 각 음식 종류별로 처리 (0번은 물이므로 1번부터 시작)
        for (int i = 1; i < food.length; i++) {
            // 각 선수에게 할당될 음식의 개수 계산 (2로 나눈 몫)
            int count = food[i] / 2;
            
            // 해당 음식 번호를 count만큼 문자열에 추가
            for (int j = 0; j < count; j++) {
                sb.append(i);
            }
        }
        
        // 왼쪽 선수의 음식 배치
        String left = sb.toString();
        
        // 왼쪽 선수의 음식 배치를 뒤집어서 오른쪽 선수의 음식 배치 만들기
        String right = new StringBuilder(left).reverse().toString();
        
        // 중앙에 물(0) 배치하고 결과 반환
        return left + "0" + right;
    }
}
