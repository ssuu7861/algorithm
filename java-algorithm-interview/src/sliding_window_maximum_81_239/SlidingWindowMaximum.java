package sliding_window_maximum_81_239;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1, -1};
        int k = 1;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) { // Node class 사용
        Deque<Node> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];

        for(int i = 0 ; i < nums.length ; i++) {
            while (!deque.isEmpty() && deque.getLast().value < nums[i]) deque.removeLast(); // getLast, removeLast는 Deque가 비어있을 시 NoSuchElementException 발생시킴!
            deque.addLast(new Node(nums[i], i));

            if(deque.getFirst().index <= i - k) deque.removeFirst();
            if(i >= k - 1) result[i - k + 1] = deque.getFirst().value;
        }
        return result;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) { //  Node class x, Deque에 index만 저장하고 index에 해당하는 값을 nums에서 찾아야 해 -> 조금 더 느림
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];

        for(int i = 0 ; i < nums.length ; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast(); // peekLast, pollLast는 Deque이 비어있을 시 null 반환
            deque.addLast(i);
            
            if(deque.peekFirst() <= i - k) deque.pollFirst();
            if(i >= k - 1) result[i - k + 1] = nums[deque.peekFirst()];
        }

        return result;
    }
}

class Node {
    public int value;
    public int index;

    Node(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
