package single_number_76_136;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for(int number : nums) result ^= number;
        return result;
    }
}
