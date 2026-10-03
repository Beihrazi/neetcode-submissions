class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>());
        return res;
    }
    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> temp){

        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i : nums){
            if(temp.contains(i)) continue;
            temp.add(i);
            backtrack(nums, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
