class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while(low<=high){
            int mid = low + (high -low)/2;

            if(nums[mid] == target) return mid;

            //left to mid is it sorted
            if(nums[low] <= nums[mid]){

                //check if target lies within range left to mid
                if(nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{

                //we know right is sorted since left has jump point somewhere
                //check if target lies within right range mid to high

                if(nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
