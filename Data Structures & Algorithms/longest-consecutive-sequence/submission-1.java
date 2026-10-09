class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int i : nums){
            hs.add(i);
        }
        int res = 0;
        for(int element : hs){
            int count = 1;

            if(!hs.contains(element - 1)){
                int start = element;
                
                while(hs.contains(start + 1)){
                    start += 1;
                    count++;
                }
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
