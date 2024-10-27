package best_time_to_buy_and_sell_stock_12_121;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {8, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices){
        int lowPoint = prices[0];
        int maxProfit = 0;
        for(int price : prices){
            if(lowPoint > price) lowPoint = price;
            maxProfit = Math.max(maxProfit, price - lowPoint);
        }
        return maxProfit;
    }
}
