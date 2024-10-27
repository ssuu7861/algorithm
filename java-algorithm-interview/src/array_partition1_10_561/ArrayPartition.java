package array_partition1_10_561;

import java.util.Arrays;

public class ArrayPartition {
    public static void main(String[] args) {
        int[] intArr = {1, 3, 4, 2};
        System.out.println(arrayPairSum(intArr));
    }

    public static int arrayPairSum(int[] nums){

        int sum = 0;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++){
            if(i % 2 == 0){
                sum += nums[i];
            }
        }
        
        return sum;
    }
}
