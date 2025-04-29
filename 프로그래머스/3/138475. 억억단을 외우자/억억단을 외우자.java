class Solution {
    public int[] solution(int e, int[] starts) {
        // 1. 약수의 개수 계산
        int[] divisors = new int[e + 1];
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                divisors[j]++;
            }
        }
        
        // 2. 각 시작점에 대해 가장 많이 등장하는 숫자 미리 계산
        int[] mostFrequent = new int[e + 1];
        int maxDivisors = 0;
        int maxNumber = 0;
        
        for (int i = e; i >= 1; i--) {
            if (divisors[i] >= maxDivisors) {
                maxDivisors = divisors[i];
                maxNumber = i;
            }
            mostFrequent[i] = maxNumber;
        }
        
        // 3. 각 쿼리에 대한 결과 계산
        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            answer[i] = mostFrequent[starts[i]];
        }
        
        return answer;
    }
}
