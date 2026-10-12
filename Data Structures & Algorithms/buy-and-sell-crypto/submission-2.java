class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int bought = Integer.MAX_VALUE, sell = 0;

        for(int i=0;i<prices.length;i++){
            if(prices[i] < bought){
                bought = prices[i];
            }else{
                sell = prices[i] - bought;
                profit = Math.max(profit, sell);
            }
        }
        return profit;
    }
}
