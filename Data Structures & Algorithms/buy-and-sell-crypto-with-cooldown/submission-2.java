class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        dp[n][0] = 0;
        dp[n][1] = 0;

        dp[n+1][0] = 0;

        for(int i=n-1;i>=0;i--){
            int buy = -prices[i] + dp[i+1][0];
            int skip = dp[i+1][1];
            dp[i][1] = Math.max(buy,skip);

            int sell = prices[i] + dp[i+2][1];
            int sskip = dp[i+1][0];
            dp[i][0] = Math.max(sell,sskip);
        }

        return dp[0][1];
    }
   
}
