package largest_number_67_179;

import java.math.BigInteger;
import java.util.Arrays;

public class LargestNumber {

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        
        int i = 1;
        while (i < nums.length) {
            int j = i;
            while (j > 0 && toSwap(nums[j - 1], nums[j])) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
            i++;
        }

        if(nums[0] == 0) return "0";
        else return Arrays.toString(nums).replaceAll("[\\[\\], ]", "");
    }

    public static boolean toSwap(int a, int b) {
        BigInteger a1 = new BigInteger(String.valueOf(a) +  b);
        BigInteger b1 = new BigInteger(String.valueOf(b) + a);
        return a1.compareTo(b1) < 0;
    }

    public static String largestNumber2(int[] nums) { // Arrays.sort 사용
        String[] s = new String[nums.length];         
        for(int i = 0 ; i < nums.length ; i++)  s[i] = String.valueOf(nums[i]);
        Arrays.sort(s, (a , b) -> (b + a).compareTo(a + b));
        return s[0].equals("0") ? "0" : String.join("", s);
    }
}
