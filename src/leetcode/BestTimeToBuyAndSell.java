package leetcode;
public class BestTimeToBuyAndSell {

    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (prices == null || prices.length == 0)
            return 0;
        int min = prices[0];
        int max = 0;
        int maxDifference = 0;
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
                max = 0;
            } else if (max < prices[i])
                max = prices[i];
            if (maxDifference < max - min)
                maxDifference = max - min;
        }
        return maxDifference;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSell bt = new BestTimeToBuyAndSell();
        int[] prices = { 2, 4, 1 };
        System.out.println(bt.maxProfit(prices));
    }

}
