import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> X = new ArrayList<>();
        
        for (int a : arr) {
            for (int i = 0; i < a; i++) {
                X.add(a);
            }
        }
        
        return X.stream().mapToInt(Integer::intValue).toArray();
    }
}