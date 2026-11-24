class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 != 0) return false;
        int t = sum/2;
        Boolean[][] dp = new Boolean[nums.length + 1][t + 1];
        
        for(Boolean[] row : dp){
            Arrays.fill(row, null);
        }
        return fn(0, t, nums, dp);
    }
    public boolean fn(int i, int t, int[] nums, Boolean[][] dp){

        if(t == 0) return true;

        
        if(i == nums.length) return false;

        if(dp[i][t] != null) return dp[i][t];

        boolean take = false;
        if (nums[i] <= t) {
            take = fn(i + 1, t - nums[i], nums, dp);
        }
        boolean skip = fn(i + 1, t, nums, dp);

        return dp[i][t] =  take || skip;
    }
}
