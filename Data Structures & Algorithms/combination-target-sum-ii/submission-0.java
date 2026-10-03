class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;
    }
    public void backtrack(int[] nums, int target, int start,  int sum, List<Integer> temp, List<List<Integer>> res){

        if(sum == target){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(sum > target) return;

        for(int i = start;i<nums.length;i++){
            
            if(i > start && nums[i] == nums[i-1]) continue;

            temp.add(nums[i]);
            backtrack(nums, target, i + 1, sum + nums[i], temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
