package sort_colors_69_75;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        int[] nums = {2, 0, 1, 2, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) { // Dutch National Flag Problem
        int red = 0;
        int white = 0;
        int blue = nums.length;

        while(white < blue) {
            if(nums[white] < 1) {
                int temp = nums[red];
                nums[red] = nums[white];
                nums[white] = temp;
                red++;
                white++;
            } else if(nums[white] > 1) {
                blue--;
                int temp = nums[blue];
                nums[blue] = nums[white];
                nums[white] = temp;
            } else white++;
        }
    }
}
