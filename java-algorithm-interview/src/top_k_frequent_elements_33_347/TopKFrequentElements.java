package top_k_frequent_elements_33_347;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import org.w3c.dom.stylesheets.LinkStyle;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent1(nums, k)));
        System.out.println(Arrays.toString(topKFrequent2(nums, k)));
    }

    public static int[] topKFrequent1(int[] nums, int k) { // 직관적인 풀이
        HashMap<Integer, Integer> frequencyHashMap = new HashMap<>();
        HashMap<Integer, List<Integer>> reverseHashMap = new HashMap<>();
        int[] result = new int[k];
        for(int i : nums) frequencyHashMap.put(i, frequencyHashMap.getOrDefault(i, 0) + 1);

        for(int i : frequencyHashMap.keySet()) {
            int frequency = frequencyHashMap.get(i);
            List<Integer> list = reverseHashMap.getOrDefault(frequency, new ArrayList<>());
            list.add(i);
            reverseHashMap.put(frequency, list);
        }

        int index = 0;
        for(int frequency = nums.length ; frequency >= 0 && index < k ; frequency--) {
            if(reverseHashMap.get(frequency) != null) {
                for(int element : reverseHashMap.get(frequency)) {
                    result[index] = element;
                    index++;
                }
            }
        }

        return result;

    }

    public static int[] topKFrequent2(int[] nums, int k) { // 우선순위 큐 이용
        HashMap<Integer, Integer> frequencyHashMap = new HashMap<>();
        for(int i : nums) frequencyHashMap.put(i, frequencyHashMap.getOrDefault(i, 0) + 1);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i : frequencyHashMap.keySet()) priorityQueue.add(new int[]{i, frequencyHashMap.get(i)});
        int[] result = new int[k];
        for(int i = 0 ; i < k ; i++) result[i] = priorityQueue.poll()[0];

        return result;
    }
}
