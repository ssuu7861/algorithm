package climbing_stairs_93_70;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    static int[] dp = new int[46];
    public static int climbStairs(int n) {
        if(n <= 2) return n;
        if(dp[n] != 0) return dp[n];
        dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return dp[n];
    }
}
