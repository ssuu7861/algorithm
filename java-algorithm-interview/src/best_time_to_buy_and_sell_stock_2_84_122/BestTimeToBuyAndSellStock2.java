package best_time_to_buy_and_sell_stock_2_84_122;

public class BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int result = 0;
        for(int i = 1 ; i < prices.length; i++) {
            if(prices[i] > prices [i - 1]) result += prices[i] - prices[i - 1];
        }
        return result;
    }
}
