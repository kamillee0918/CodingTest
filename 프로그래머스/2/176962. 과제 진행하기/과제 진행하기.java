import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> completed = new ArrayList<>();
        
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> a.startTime - b.startTime);
        for (String[] plan : plans) {
            String name = plan[0];
            int startTime = convertTimeToMinutes(plan[1]);
            int playTime = Integer.parseInt(plan[2]);
            pq.add(new Task(name, startTime, playTime));
        }
        
        Stack<Task> paused = new Stack<>();
        int currentTime = 0;
        
        while (!pq.isEmpty() || !paused.isEmpty()) {
            if (paused.isEmpty() && !pq.isEmpty()) {
                Task current = pq.poll();
                currentTime = current.startTime;
                
                if (!pq.isEmpty()) {
                    Task next = pq.peek();
                    
                    if (currentTime + current.playTime <= next.startTime) {
                        completed.add(current.name);
                        currentTime += current.playTime;
                    } else {
                        current.playTime -= (next.startTime - currentTime);
                        paused.push(current);
                        currentTime = next.startTime;
                    }
                } else {
                    completed.add(current.name);
                    currentTime += current.playTime;
                }
            } else {
                if (!pq.isEmpty() && currentTime < pq.peek().startTime) {
                    Task pausedTask = paused.pop();
                    int timeUntilNext = pq.peek().startTime - currentTime;
                    
                    if (pausedTask.playTime <= timeUntilNext) {
                        completed.add(pausedTask.name);
                        currentTime += pausedTask.playTime;
                    } else {
                        pausedTask.playTime -= timeUntilNext;
                        paused.push(pausedTask);
                        currentTime = pq.peek().startTime;
                    }
                } else if (pq.isEmpty()) {
                    while (!paused.isEmpty()) {
                        completed.add(paused.pop().name);
                    }
                } else {
                    Task current = pq.poll();
                    currentTime = current.startTime;
                    
                    if (!pq.isEmpty()) {
                        Task next = pq.peek();
                        
                        if (currentTime + current.playTime <= next.startTime) {
                            completed.add(current.name);
                            currentTime += current.playTime;
                        } else {
                            current.playTime -= (next.startTime - currentTime);
                            paused.push(current);
                            currentTime = next.startTime;
                        }
                    } else {
                        completed.add(current.name);
                        currentTime += current.playTime;
                    }
                }
            }
        }
        
        return completed.toArray(new String[0]);
    }
    
    private int convertTimeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
    class Task {
        String name;
        int startTime;
        int playTime;
        
        Task(String name, int startTime, int playTime) {
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }
    }
}
