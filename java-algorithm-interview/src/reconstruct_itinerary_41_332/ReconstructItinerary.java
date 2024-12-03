package reconstruct_itinerary_41_332;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>(Arrays.asList(
            Arrays.asList("MUC", "ICN"),
            Arrays.asList("JFK", "MUC"),
            Arrays.asList("SFO", "SJC"),
            Arrays.asList("ICN", "SFO")
        ));
        System.out.println(findItinerary(tickets));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new LinkedList<>();
        Map<String, PriorityQueue<String>> itineraryMap = new HashMap<>();
        for(List<String> list : tickets) {
            itineraryMap.putIfAbsent(list.get(0), new PriorityQueue<>());
            itineraryMap.get(list.get(0)).add(list.get(1));
        }

        dfs("JFK", result, itineraryMap);
        return result;
    }

    public static void dfs(String from, List<String> result, Map<String, PriorityQueue<String>> itineraryMap) {
        
        while (itineraryMap.containsKey(from) && !itineraryMap.get(from).isEmpty()) {
            dfs(itineraryMap.get(from).poll(), result, itineraryMap);
        }
        
        result.add(0, from);

    }
}
