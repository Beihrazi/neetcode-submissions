class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for(int i : nums){
            sum += i;
        }
        int W = sum/2;
        if(sum % 2 != 0) return false;
        boolean[][] dp = new boolean[nums.length][W + 1];

        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        //for single element
        for(int w = 0; w<=W;w++){
            dp[0][w] = (nums[0] == w);
        }

        for(int i=1;i<n;i++){
            for(int w=0;w<=W;w++){
                
                boolean nottake = dp[i-1][w];
                boolean take = false;

                if(nums[i] <= w){
                    take = dp[i-1][w-nums[i]];
                }

                dp[i][w] = take || nottake;
            }
        }
        return dp[n-1][W];
    }
   
}
