package queue_reconstruction_by_height_85_406;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueReconstructionByHeight {

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }

    public static int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new LinkedList<>();
        Queue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        for(int[] person : people) priorityQueue.add(person);
        while (!priorityQueue.isEmpty()) {
            int[] person = priorityQueue.poll();
            result.add(person[1], person);
        }
        return result.toArray(new int[people.length][2]);
    }
}
