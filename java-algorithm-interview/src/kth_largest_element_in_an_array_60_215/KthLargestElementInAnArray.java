package kth_largest_element_in_an_array_60_215;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : nums) priorityQueue.add(n);
        for(int i = 0 ; i < k - 1 ; k++) priorityQueue.poll();

        return priorityQueue.poll();
    }
}
