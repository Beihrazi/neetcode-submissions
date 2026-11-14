class Solution {
    public int rob(int[] nums) {
        int next1 = 0, next2 = 0;
        for(int i=nums.length - 1; i>=0;i--){
            int cur = Math.max(nums[i] + next2, next1);

            int temp = next1;
            next1 = cur;
            next2 = temp;
        }
        return next1;
    }
}
