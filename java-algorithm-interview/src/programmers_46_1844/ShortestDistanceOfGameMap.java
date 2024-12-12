package programmers_46_1844;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestDistanceOfGameMap {

    public static void main(String[] args) {
        int[][] maps = {{1, 1, 1, 1, 0}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 0}, {1, 1, 1, 0, 0}, {1, 1, 1, 1, 1}};
        System.out.println(shortestDistanceOfGameMap(maps));
        //System.out.println(shortestDistanceOfGameMap2(maps));
    }

    // 일반적인 BFS
    public static int shortestDistanceOfGameMap(int[][] maps) {
        int [][] xy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0, 1));
        maps[0][0] = 0;
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            if(pos.x == n - 1 && pos.y == m - 1) return pos.distance;

            for(int[] dxy : xy) {
                int tmpX = pos.x + dxy[0];
                int tmpY = pos.y + dxy[1];

                if(tmpX >= 0 && tmpY >= 0 && tmpX < n && tmpY < m && maps[tmpX][tmpY] == 1) { 
                    maps[tmpX][tmpY] = 0;
                    queue.offer(new Position(tmpX, tmpY, pos.distance + 1));
                }
            }
        }
        return -1;
    }

    // PriorityQueue
    public static Queue<Position> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
    public static int shortestDistanceOfGameMap2(int[][] maps) {
        for(int i = 0 ; i < maps.length ; i++) {
            for(int j = 0 ; j < maps[0].length ; j++) {
                System.out.print(maps[i][j] + " ");
            }
            System.out.println();
        }

        pq.add(new Position(0, 0, 1));
        Map<Integer, Position> dist = new LinkedHashMap<>();

        while (!pq.isEmpty()) {
            Position cur = pq.poll();
            if(!dist.containsKey(cur.x + 1000 + cur.y)) { // x, y 두개를 함께 저장할 수 없으므로 x * 1000 + y로 바꿔 키로 사용
                dist.put(cur.x * 1000 + cur.y, cur);

                findPath(cur.x, cur.y + 1, cur.distance, maps);
                findPath(cur.x, cur.y - 1, cur.distance, maps);
                findPath(cur.x + 1, cur.y, cur.distance, maps);
                findPath(cur.x - 1, cur.y, cur.distance, maps);
            }
        }
        if(dist.containsKey((maps.length - 1) * 1000 + (maps[0].length - 1))) {
            return dist.get(((maps.length - 1) * 1000 + (maps[0].length - 1))).distance;
        }
        return -1;
    }

    public static void findPath(int x, int y, int distance, int[][] maps) {
        if(x >= 0 && x < maps.length && y >= 0 && y < maps[0].length && maps[x][y] != 0) {
            maps[x][y] = 0;
            pq.add(new Position(x, y, distance + 1));
        }
    }
}


class Position {
    public int x, y, distance;
    
    Position(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
