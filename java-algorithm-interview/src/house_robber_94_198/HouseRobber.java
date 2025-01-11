package house_robber_94_198;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        
        for(int i = 2 ; i < nums.length ; i++) dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        return dp[nums.length - 1];
    }
}
