package leetcode.arrays;

public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        int result = maxProfit(arr);
        System.out.println(result);

    }

    private static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i]<min){
                min = prices[i];
            }
            if ((prices[i] - min) > profit) {
                profit = prices[i] - min;
            }
        }
        return profit;
    }
}
