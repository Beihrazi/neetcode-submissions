class Solution {
    public void sortColors(int[] nums) {
        int l=0, i=0, r= nums.length-1;
        while(i<=r){
            if(nums[i] == 0){
                swap(i,l,nums);
                l++;
            }else if(nums[i] == 2){
                swap(i,r,nums);
                r--;
                i--;
            }
            i++;
        }
    }
    public void swap(int i, int n, int[] nums){
        int temp = nums[i];
        nums[i] = nums[n];
        nums[n] = temp;
    }
}