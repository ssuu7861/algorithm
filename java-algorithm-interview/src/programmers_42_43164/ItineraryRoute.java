package programmers_42_43164;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ItineraryRoute {

    public static void main(String[] args) {
        String[][] tickets = new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println(Arrays.toString(itineraryRoute(tickets)));
    }

    public static String[] itineraryRoute(String[][] tickets) {
        Map<String, PriorityQueue<String>> itineraryMap = new HashMap<>();
        Deque<String> stack = new ArrayDeque<>();
        List<String> answer = new LinkedList<>();
        
        for(String[] ticket : tickets) {
            itineraryMap.putIfAbsent(ticket[0], new PriorityQueue<>());
            itineraryMap.get(ticket[0]).add(ticket[1]);
        }

        stack.push("ICN");
        while (!stack.isEmpty()) {
            String s = stack.getFirst();
            while (itineraryMap.containsKey(s) && !itineraryMap.get(s).isEmpty()) {
                stack.push(itineraryMap.get(s).poll());
            }
            answer.add(0, stack.pop());

        }

        return answer.toArray(new String[0]);
    }
}
