class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i: nums){
            hm.put(i, hm.getOrDefault(i,0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(int i: hm.keySet()){
            int fq = hm.get(i);
            if(bucket[fq]==null){
                bucket[fq] = new ArrayList<>();
            }
            bucket[fq].add(i);
        }
        int[] res = new int[k];
        int c=0;
        for(int i=nums.length;i>0 && c<k; i--){
            if(bucket[i] !=null){
                for(Integer j : bucket[i]){
                    res[c++] = j;
                    if(c == k) break;
                }
            }
        }
        return res;
    }
}
