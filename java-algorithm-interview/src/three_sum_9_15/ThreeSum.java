package three_sum_9_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -5};  // -5 -1 -1 0 1 2
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        int right, left, sum;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i < nums.length - 2 ; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            right = nums.length - 1;
            left = i + 1;
            while(left < right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum < 0){
                    left++;
                }
                else if(sum > 0){
                    right--;
                }
                else{
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}

