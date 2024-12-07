package network_delay_time_44_743;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// PriorityQueue를 이용해 구현한 Dijkstra Algorithm

public class NetworkDelayTime {

    public static void main(String[] args) {
        
        int[][] times = {{3, 1, 5}, {3, 2, 2}, {2, 1, 2}, {3, 4, 1}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}, {7, 8, 1}, {8, 1, 1}};
        int n = 8, k = 3;
        System.out.println(networkDelayTime(times, n, k));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }

        Queue<Map.Entry<Integer,Integer>> prioritiyQueue = new PriorityQueue<>(Map.Entry.comparingByValue());
        prioritiyQueue.add(new AbstractMap.SimpleEntry<>(k, 0));

        Map<Integer, Integer> dist = new HashMap<>(); // 최종 길이 저장 (시작지는 fixed -> 도착지, 시간)
        while (!prioritiyQueue.isEmpty()) {
            Map.Entry<Integer, Integer> current = prioritiyQueue.poll();
            int u = current.getKey();
            int distU = current.getValue();

            if(!dist.containsKey(u)) {
                dist.put(u, distU);

                if(graph.containsKey(u)) {
                    for(Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                        prioritiyQueue.add(new AbstractMap.SimpleEntry<>(v.getKey(), v.getValue() + distU));
                    }
                }
            }
        }

        if(dist.size() == n) return Collections.max(dist.values());
        return -1;
    }
}
