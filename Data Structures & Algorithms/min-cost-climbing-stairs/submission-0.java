class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return Math.min(fn(cost, 0, cost.length, dp), fn(cost, 1, cost.length, dp));
    }
    public int fn(int[] cost, int i, int n, int[] dp){
        if(i == n) return 0;

        if(dp[i] != -1) return dp[i];

        int one = fn(cost, i + 1,n,dp) + cost[i];
        int two = Integer.MAX_VALUE;
        if(i+2 <= n){
            two = fn(cost, i+2, n,dp) + cost[i];
        }
        dp[i] = Math.min(one, two);
        return dp[i];
    }
}
