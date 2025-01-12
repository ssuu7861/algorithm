package programmers_95_42897;

import java.util.Arrays;

public class Thievery {

    public static void main(String[] args) {
        int[] money = {10, 2, 2, 100, 2};
        System.out.println(thievery(money));
    }
    public static int thievery(int[] money) {
        if(money.length == 3) return Arrays.stream(money).max().getAsInt();

        int[][] dp = new int[2][money.length];

        dp[0][0] = money[0];
        dp[0][1] = Math.max(money[0], money[1]); // dp[1][1] 은 money[1]을 무조건 뽑으니까 dp[0][] 라인은 둘 중 큰걸 골라아한다!
        dp[1][1] = money[1];
        
        for(int i = 2 ; i < money.length ; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + money[i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + money[i]);
        }

        return Math.max(dp[0][money.length - 2], dp[1][money.length - 1]);
    }
}
