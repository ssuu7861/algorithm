package two_sum_7_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 6, 11, 15};
        int target = 8;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }


    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){
            if(hashMap.containsKey(target - nums[i])) return new int[]{hashMap.get(target - nums[i]), i};
            hashMap.put(nums[i], i);
        }
        return null;
    }
}