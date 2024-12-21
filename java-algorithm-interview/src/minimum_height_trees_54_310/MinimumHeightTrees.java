package minimum_height_trees_54_310;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinimumHeightTrees {

    public static void main(String[] args) {
        
        int n = 7;
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 3}, {6, 5}};
        System.out.println(findMinHeightTrees(n, edges));
    }


    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Arrays.asList(0);
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges) {
            graph.putIfAbsent(edge[0], new LinkedList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.putIfAbsent(edge[1], new LinkedList<>());
            graph.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new LinkedList<>();

        for(int i = 0 ; i < n ; i++) {
            if(graph.containsKey(i) && graph.get(i).size() == 1) leaves.add(i);
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new LinkedList<>();
            for(int leaf : leaves) {
                int neighbor = graph.get(leaf).get(0);
                graph.get(neighbor).remove((Object) leaf);
                if(graph.get(neighbor).size() == 1) newLeaves.add(neighbor);
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }
}
