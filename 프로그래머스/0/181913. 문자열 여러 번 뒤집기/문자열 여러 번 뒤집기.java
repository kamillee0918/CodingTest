class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] chars = my_string.toCharArray();
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            reverseString(chars, start, end);
        }
        
        return new String(chars);
    }
    
    private void reverseString(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}