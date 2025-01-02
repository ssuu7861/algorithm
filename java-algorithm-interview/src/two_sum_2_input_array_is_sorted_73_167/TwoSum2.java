package two_sum_2_input_array_is_sorted_73_167;

import java.util.Arrays;

public class TwoSum2 {

    public static void main(String[] args) {
        int[] numbers = {2, 6, 11, 15};
        int target = 8;
        System.out.println(Arrays.toString(twoSum2(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) { // Two - pointer
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if(numbers[left] + numbers[right] < target) left++;
            else if(numbers[left] + numbers[right] > target) right--;
            else return new int[]{left + 1, right + 1};
        }
        return null;
    }

    public static int[] twoSum2(int[] numbers, int target) { // Binary search
        
        for(int i = 0 ; i < numbers.length ; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            int tempTarget = target - numbers[i];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if(numbers[mid] > tempTarget) right = mid - 1;
                else if(numbers[mid] < tempTarget) left = mid + 1;
                else return new int[]{i + 1, mid + 1};
            }
        }
        return null;
    }
}
