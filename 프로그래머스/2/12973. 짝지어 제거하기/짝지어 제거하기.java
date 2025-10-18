class Solution {
    public int solution(String s) {
        char[] stack = new char[s.length()];
        int top = -1;  // 스택의 top 포인터
        
        for (char c : s.toCharArray()) {
            if (top >= 0 && stack[top] == c) {
                top--;  // pop
            } else {
                // 그 외의 경우 스택에 추가
                stack[++top] = c;  // push
            }
        }
        
        // top이 -1이면 스택이 비어있음
        return top == -1 ? 1 : 0;
    }
}