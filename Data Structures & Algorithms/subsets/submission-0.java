class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        compute(nums, 0, new ArrayList<>(), res);
        return res;
    }
    public void compute(int[] nums, int start, List<Integer> temp, List<List<Integer>> res){
        res.add(new ArrayList<>(temp));

        for(int i = start;i<nums.length;i++){
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);

            compute(nums, i+1, temp, res);

            temp.remove(temp.size() - 1);
        }
    }
}
