package programmers_61_42628;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class DoublyPriorityQueue {

    public static void main(String[] args) {
        
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(doublyPriorityQueue(operations)));
    }

    public static int[] doublyPriorityQueue(String[] operations) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation : operations) {
            String[] op = operation.split(" ");
            if("I".equals(op[0])) {
                minHeap.add(Integer.parseInt(op[1]));
                maxHeap.add(Integer.parseInt(op[1]));
            }
            else if("D".equals(op[0])) {
                if("1".equals(op[1])) minHeap.remove(maxHeap.poll());
                else maxHeap.remove(minHeap.poll());
            }
        }
        Integer max = maxHeap.poll();
        Integer min = minHeap.poll();
        
        return new int[] {max == null ? 0 : max, min == null ? 0 : min};
    }

}
