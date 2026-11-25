class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 != 0) return false;
        Boolean[][] dp = new Boolean[nums.length][sum/2 + 1];

        return fn(nums.length-1, sum/2, nums, dp);
    }
    public boolean fn(int i, int w, int[] nums, Boolean[][] dp){
        if(w == 0) return true;
        if(w < 0) return false;
        if(i == 0){
            return nums[i] == w;
        }
        if(dp[i][w] != null) return dp[i][w];

        boolean take = false; 
        if(nums[i] <= w){
            take = fn(i-1, w-nums[i], nums, dp);
        }
        boolean nottake = fn(i-1, w, nums, dp);

        return dp[i][w] = take || nottake;
    }
}
