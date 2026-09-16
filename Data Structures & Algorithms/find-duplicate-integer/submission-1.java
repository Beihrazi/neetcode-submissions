class Solution {
    public int findDuplicate(int[] nums) {
       
            int slow = 0;
            int fast = 0;

            do{
                slow = nums[slow];
                fast = nums[nums[fast]];

                if(slow == fast){
                    break;
                }
            }while(slow != fast);

            slow = 0;
            while(nums[slow] != nums[fast]){
                slow = nums[slow];
                fast = nums[fast];
            }
            return nums[slow];
       
    }
}
