class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        left[0] = 1;
        int[] right = new int[n];
        right[n-1] = 1;

        for(int l=1;l<n;l++){
            left[l] = left[l-1] * nums[l-1];
        }
        for(int r=n-2;r>=0;r--){
            right[r] = nums[r+1] * right[r+1];
        }
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = left[i] * right[i];
        }
        return res;
    }
}  
