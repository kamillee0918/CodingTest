class Solution {
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        boolean[] visited = new boolean[n];
        
        // target 단어가 words에 없으면
        // 변환 불가
        boolean targetExists = false;
        
        for (String w : words) {
            if (w.equals(target)) {
                targetExists = true;
                break;
            }
        }
        
        if (!targetExists) {
            return 0; // 변환할 수 없는 경우 0 반환
        }
        
        // 큐 배열 구현(최대 words.length + 1)
        String[] queue = new String[n + 1];
        int[] depth = new int[n + 1];
        int front = 0;
        int rear = 0;
        
        // 시작 단어를 삽입
        queue[rear] = begin;
        depth[rear] = 0;
        rear++;
        
        while (front < rear) {
            String curr = queue[front];
            int currDepth = depth[front];
            front++;
            
            if (curr.equals(target)) {
                return currDepth; // 변환에 성공한 경우
            }
            
            // 변환 가능한 단어 모두를 큐에 삽입
            for (int i = 0; i < n; i++) {
                if (!visited[i] && checkConvert(curr, words[i])) {
                    visited[i] = true;
                    queue[rear] = words[i];
                    depth[rear] = currDepth + 1;
                    rear++;
                }
            }
        }
        
        // 변환할 수 없는 경우 0 반환
        return 0;
    }
    
    // 한 글자만 다른지 확인하는 함수
    private boolean checkConvert(String a, String b) {
        int diff = 0;
        
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        
        return diff == 1;
    }
}