package leetcode.greedy;

public class BestTimeToBuyAndSellStock2 {
    
    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(prices == null || prices.length == 0 || prices.length == 1)
            return 0;
            
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1])
                maxProfit += prices[i] - prices[i-1];
        }
        return maxProfit;
    }
    
    public static void main(String[] args) { 
        BestTimeToBuyAndSellStock2 bt = new BestTimeToBuyAndSellStock2();
        int[] prices = {2,1,2,0,4};  
        System.out.println(bt.maxProfit(prices));  
    }  
}
