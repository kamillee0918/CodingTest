import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // 인덱스 저장용 스택

        // 오른쪽부터 순회
        for (int i = n - 1; i >= 0; i--) {
            // 스택 top이 현재 숫자보다 작거나 같으면 pop
            while (!stack.isEmpty() && numbers[stack.peek()] <= numbers[i]) {
                stack.pop();
            }

            // 스택이 비어있으면 뒷 큰 수 없음 (-1), 아니면 top 인덱스의 숫자
            answer[i] = stack.isEmpty() ? -1 : numbers[stack.peek()];

            // 현재 인덱스를 스택에 추가
            stack.push(i);
        }

        return answer;
    }
}
