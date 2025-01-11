package maximum_subarray_92_53;

import java.util.Arrays;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) { // memoization .. 이전 값을 nums에 저장
        for(int i = 1 ; i < nums.length ; i++) {
            nums[i] += (nums[i - 1] > 0) ? nums[i - 1] : 0;
        }
        return Arrays.stream(nums).max().getAsInt();
    }

    public static int maxSubArray2(int[] nums) { // Kadane's Algorithm
        int current = 0;
        int best = Integer.MIN_VALUE;
        for(int num : nums) {
            current = Math.max(num, current + num);
            best = Math.max(best, current);
        }
        return best;
    }
}
