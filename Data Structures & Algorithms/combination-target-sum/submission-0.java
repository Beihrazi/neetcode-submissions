class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int sum=0;
        backtrack(nums, target, 0, new ArrayList<>(), res, sum);
        return res;
    }
    public void backtrack(int[] nums, int target, int start, List<Integer> temp, List<List<Integer>> res, int sum){

        if(sum == target){
                res.add(new ArrayList<>(temp));
                return;
        }
        if(sum > target) return;

        for(int i = start;i<nums.length;i++){
            temp.add(nums[i]);
            backtrack(nums, target, i, temp, res, sum + nums[i]);
            
            temp.remove(temp.size() - 1);
        }
    }
}
