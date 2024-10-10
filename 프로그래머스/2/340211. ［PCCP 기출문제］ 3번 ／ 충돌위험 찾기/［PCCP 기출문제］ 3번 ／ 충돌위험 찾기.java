import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int collisionCount = 0;
        int maxTime = 0;
        Map<Integer, int[]> pointMap = new HashMap<>();
        
        // 포인트 번호와 좌표를 매핑
        for (int i = 0; i < points.length; i++) {
            pointMap.put(i+1, points[i]);
        }
        
        // 각 로봇의 경로를 좌표로 변환
        List<List<int[]>> paths = new ArrayList<>();
        for (int[] route : routes) {
            List<int[]> path = new ArrayList<>();
            for (int point : route) {
                path.add(pointMap.get(point));
            }
            paths.add(path);
            maxTime = Math.max(maxTime, getPathTime(path));
        }
        
        // 시뮬레이션
        for (int time = 0; time <= maxTime; time++) {
            Map<String, Integer> positionCount = new HashMap<>();
            
            for (List<int[]> path : paths) {
                int[] position = getPositionAtTime(path, time);
                if (position != null) {
                    String key = position[0] + "," + position[1];
                    positionCount.put(key, positionCount.getOrDefault(key, 0) + 1);
                }
            }
            
            // 충돌 위험 카운트
            for (int count : positionCount.values()) {
                if (count >= 2) {
                    collisionCount++;
                }
            }
        }
        
        return collisionCount;
    }
    
    // 경로의 총 소요 시간을 계산
    private int getPathTime(List<int[]> path) {
        int time = 0;
        for (int i = 1; i < path.size(); i++) {
            time += getManhattanDistance(path.get(i-1), path.get(i));
        }
        
        return time;
    } 
    
    // 맨해튼 거리를 계산
    private int getManhattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
    
    // 주어진 시간에 로봇의 위치(좌표) 계산
    private int[] getPositionAtTime(List<int[]> path, int time) {
        int elapsedTime = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            int segmentTime = getManhattanDistance(path.get(i), path.get(i+1));
            if (elapsedTime == time) {
                return path.get(i);  // 정확히 포인트에 도착한 경우
            }
            if (elapsedTime + segmentTime > time) {
                // 현재 세그먼트 내에서 위치를 계산
                int remainingTime = time - elapsedTime;
                int[] start = path.get(i);
                int[] end = path.get(i+1);
                int[] direction = {Integer.compare(end[0], start[0]), Integer.compare(end[1], start[1])};

                // r 좌표부터 변경
                int rChange = Math.min(remainingTime, Math.abs(end[0] - start[0]));
                int[] position = {start[0] + direction[0] * rChange, start[1]};

                // 남은 시간이 있으면 c 좌표 변경
                int cChange = remainingTime - rChange;
                position[1] += direction[1] * cChange;

                return position;
            }
            elapsedTime += segmentTime;
        }

        // 마지막 포인트에 도착한 경우
        if (elapsedTime == time) {
            return path.get(path.size() - 1);
        }

        // 경로 이동을 모두 마친 경우
        return null;
    }
}