import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        // 1. 몸무게를 오름차순으로 정렬
        Arrays.sort(people);
        
        int answer = 0;
        int small = 0;                  // 가장 가벼운 사람
        int big = people.length - 1;    // 가장 무거운 사람
        
        // 2. 보트 배정하기
        while (small <= big) {
            /*
            가장 가벼운 사람과 가장 무거운 사람이
            함께 탈 수 있는지를 확인
            */
            if (people[small] + people[big] <= limit) {
                // 함께 탈 수 있으면 둘 다 태움
                small++;
                big--;
            } else {
                // 무거운 사람만 태움
                big--;
            }
            
            // 어떠한 경우든 보트는 1개 사용함
            answer++;
        }
        return answer;
    }
}