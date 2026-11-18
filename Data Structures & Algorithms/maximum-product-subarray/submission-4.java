class Solution {
    public int maxProduct(int[] nums) {
        int curmax = nums[0], curmin = nums[0], maxsofar = nums[0];

        for(int i=1;i<nums.length;i++){
            int maxextended = curmax * nums[i];
            int minextended = curmin * nums[i];

            curmax = Math.max(nums[i], Math.max(maxextended, minextended));
            curmin = Math.min(nums[i], Math.min(maxextended, minextended));

            maxsofar = Math.max(maxsofar, curmax);
        }
        return maxsofar;
    }
}
