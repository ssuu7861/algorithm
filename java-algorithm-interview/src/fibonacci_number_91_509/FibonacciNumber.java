package fibonacci_number_91_509;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fib3(30));
    }

    static int[] dp = new int[31];
    public static int fib(int n) { // memoization
        if(n <= 1) return n;
        if(dp[n] > 0) return dp[n];
        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }

    public static int fib2(int n) { // tabulation
        int[] tabulation = new int[31];
        tabulation[0] = 0;
        tabulation[1] = 1;

        for(int i = 2; i <= n ; i++) {
            tabulation[i] = tabulation[i - 1] + tabulation[i - 2];
        }
        return tabulation[n];
    }

    public static int fib3(int n) { // SC : O(1)
        int x = 0, y = 1;
        for(int i = 0 ; i < n ; i++) {
            int z = x + y;
            x = y;
            y = z;
        }
        return x; // n = 0 일때도 대응가능
    }
}
