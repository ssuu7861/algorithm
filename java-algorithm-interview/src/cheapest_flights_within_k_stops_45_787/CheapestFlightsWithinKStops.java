package cheapest_flights_within_k_stops_45_787;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        
        int n = 4, src = 0, dst = 3, k = 1;
        int[][] edges = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        System.out.println(findCheapestPrice2(n, edges, src, dst, k));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) { // Time Limit Exceeded
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] flight : flights) {
            graph.putIfAbsent(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1], flight[2]);
        }
        Queue<List<Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
        priorityQueue.add(Arrays.asList(src, 0, -1)); // List : dst, cost, k

        while(!priorityQueue.isEmpty()) {
            List<Integer> current = priorityQueue.poll();
            int currentDst = current.get(0);
            int currentCost = current.get(1);
            int currentK = current.get(2);
            if(currentDst == dst) return currentCost;
            
            if(currentK < k) {
                if(graph.containsKey(currentDst)) {
                    for(Map.Entry<Integer, Integer> v : graph.get(currentDst).entrySet()) {
                        priorityQueue.add(Arrays.asList(v.getKey(), currentCost + v.getValue(), currentK + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] flight : flights) {
            graph.putIfAbsent(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1], flight[2]);            
        }
        Queue<List<Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
        priorityQueue.add(Arrays.asList(src, 0, 0));

        Map<Integer, Integer> visited = new HashMap<>();

        while(!priorityQueue.isEmpty()) {
            List<Integer> current = priorityQueue.poll();
            int currentDst = current.get(0);
            int currentCost = current.get(1);
            int currentK = current.get(2);
            if(currentDst == dst) return currentCost;

            visited.put(currentDst, currentK);

            if (currentK <= k) {
                currentK++;
                if(graph.containsKey(currentDst)) {
                    for(Map.Entry<Integer, Integer> v : graph.get(currentDst).entrySet()) {
                        if(!visited.containsKey(v.getKey()) || currentK < visited.get(v.getKey()))
                            priorityQueue.add(Arrays.asList(v.getKey(), currentCost + v.getValue(), currentK));
                    }
                }
            }
        }

        return -1;
    }

}
