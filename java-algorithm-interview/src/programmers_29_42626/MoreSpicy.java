package programmers_29_42626;

import java.util.PriorityQueue;

public class MoreSpicy {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(moreSpicy(scoville, k));
    }

    public static int moreSpicy(int[] scoville, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int count = 0;
        for(int s : scoville) priorityQueue.add(s);

        while (priorityQueue.peek() < k) {
            if(priorityQueue.size() < 2) return -1;
            priorityQueue.add(priorityQueue.poll() + 2 * priorityQueue.poll());
            count++;
        }

        return count;
    }
}
