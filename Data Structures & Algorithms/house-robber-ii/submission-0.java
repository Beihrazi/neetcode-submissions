class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(helper(0, n-2,n,nums), helper(1, n-1,n,nums));
    }
    public int helper(int s, int e,int n,int[] nums){
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return fn(s,e,n,nums,dp);
    }
    public int fn(int s, int e, int n, int[] nums, int[] dp){
        if(s>e) return 0;

        if(dp[s] != -1) return dp[s];
        int next2 = nums[s] + fn(s+2,e,n,nums,dp);
        int next1 = fn(s+1,e,n,nums,dp);

        dp[s] = Math.max(next2, next1);
        return dp[s];
    }
}
