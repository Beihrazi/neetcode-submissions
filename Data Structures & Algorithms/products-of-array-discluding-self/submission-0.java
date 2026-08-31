class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length, pre=1, pos=1;
        int[] res = new int[n];

        for(int i=0;i<n;i++){
            res[i] = pre;
            pre *= nums[i];
        }
        for(int i=n-1;i>=0;i--){
            res[i] *= pos;
            pos *= nums[i];
        }
        return res;
    }
}  
