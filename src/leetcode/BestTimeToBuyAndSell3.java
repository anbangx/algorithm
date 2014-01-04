package leetcode;

public class BestTimeToBuyAndSell3 {
    
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1)
            return 0;
        
        // search from left to right
        int[] maxProfits = new int[prices.length];
        int min = prices[0];
        int max = 0;
        int maxDifference = 0;
        maxProfits[0] = 0;
        for (int j = 1; j < prices.length; j++) {
            if (min > prices[j]) {
                min = prices[j];
                max = 0;
            } else if (max < prices[j])
                max = prices[j];
            if (maxDifference < max - min){
                maxDifference = max - min;
                maxProfits[j] = maxDifference;
            } else
                maxProfits[j] = maxProfits[j - 1];
        }
        
        // search from right to left
        int[] maxProfits2 = new int[prices.length];
        min = Integer.MAX_VALUE;
        max = prices[prices.length - 1];
        maxDifference = 0;
        maxProfits2[prices.length - 1] = 0;
        for (int j = prices.length - 2; j >= 0; j--) {
            if (max < prices[j]) {
                max = prices[j];
                min = Integer.MAX_VALUE;
            } else if (min > prices[j])
                min = prices[j];
            if (maxDifference < max - min){
                maxDifference = max - min;
                maxProfits2[j] = maxDifference;
            } else
                maxProfits2[j] = maxProfits2[j + 1];
        }
        
        // merge two max
        int twoMax = 0;
        for(int k = 0; k < prices.length; k++){
            if(twoMax < maxProfits[k] + maxProfits2[k]){
                twoMax = maxProfits[k] + maxProfits2[k];
            }
        }
        return twoMax;
    }
    
    public static void main(String[] args) {
        BestTimeToBuyAndSell3 bt = new BestTimeToBuyAndSell3();
        int[] prices = {2,1,2,0,1};
        System.out.println(bt.maxProfit(prices));
    }

}
