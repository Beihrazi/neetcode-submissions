class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(helper(0, n-2,n,nums), helper(1, n-1,n,nums));
    }
    public int helper(int s, int e,int n,int[] nums){
       
        int next1 = 0, next2 = 0;

        for(int i=e;i>=s;i--){
            int cur = Math.max(nums[i] + next2, next1);
            next2 = next1;
            next1 = cur;
        }

        return next1;
    }
   
}
