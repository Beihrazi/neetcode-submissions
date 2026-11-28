class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        return fn(0, 1, prices, dp);
    }
    public int fn(int i, int canBuy, int[] prices, int[][] dp){
        //canBuy - true,buy
        //canBuy - false,sell
        if(i >= prices.length) return 0;

        if(dp[i][canBuy] != -1) return dp[i][canBuy];
        if(canBuy == 1){
            int buy =-prices[i] + fn(i+1, 0, prices, dp);
            int skip = fn(i+1, canBuy, prices, dp);
            return dp[i][canBuy] = Math.max(buy,skip);
        }else{
            int sell = prices[i] + fn(i + 2, 1, prices, dp);
            int skip = fn(i+1, canBuy, prices, dp);
            return dp[i][canBuy] = Math.max(sell, skip);
        }

    }
}
