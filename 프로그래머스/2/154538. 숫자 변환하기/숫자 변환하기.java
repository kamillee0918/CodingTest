import java.util.*;

public class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) {
            return 0;
        }

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(x, 0));
        Set<Integer> visited = new HashSet<>();
        visited.add(x);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int currentValue = current.first;
            int steps = current.second;

            List<Integer> nextStates = Arrays.asList(
                currentValue + n,
                currentValue * 2,
                currentValue * 3
            );

            for (int ns : nextStates) {
                if (ns == y) {
                    return steps + 1;
                }
                if (ns < y && !visited.contains(ns)) {
                    visited.add(ns);
                    queue.add(new Pair(ns, steps + 1));
                }
            }
        }

        return -1;
    }

    private static class Pair {
        int first;
        int second;

        public Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }
}
