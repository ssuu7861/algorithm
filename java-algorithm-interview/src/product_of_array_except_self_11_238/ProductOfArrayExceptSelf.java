package product_of_array_except_self_11_238;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums){
        int[] result = new int[nums.length];
        int tmp = 1;
        for(int i = 0 ; i < nums.length ; i++){
            result[i] = tmp;
            tmp *= nums[i];
        }
        tmp = 1;
        for(int i = nums.length - 1  ; i >= 0 ; i--){
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }
}
