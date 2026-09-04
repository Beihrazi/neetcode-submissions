class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = binaryS(nums, 0, nums.length-1, target, true);
        int right = binaryS(nums, 0, nums.length-1, target, false);
        return new int[]{left,right};
    }
    public int binaryS(int[] nums, int low, int high, int target, boolean firstSearch){
        int res = -1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                res = mid;
                if(firstSearch){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return res;
    }
}