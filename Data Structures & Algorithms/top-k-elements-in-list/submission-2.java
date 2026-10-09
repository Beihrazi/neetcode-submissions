class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i : nums){
            hm.put(i, hm.getOrDefault(i,0) + 1);
        }
        int n = nums.length;
        // int[] bucket = new int[n+1];
        List<List<Integer>> bucket = new ArrayList<>();

        for(int i=0;i<=n;i++){
            bucket.add(new ArrayList<>());
        }

        for(Map.Entry<Integer, Integer> e : hm.entrySet()){
            // bucket[e.getValue()] = e.getKey();
            bucket.get(e.getValue()).add(e.getKey());
        }
        int[] res = new int[k];
        int j=0;

        for(int i=n;i>=0;i--){
            if(!bucket.get(i).isEmpty() && k>0){
                List<Integer> ls = bucket.get(i);
                for(int m=0;m<ls.size();m++){
                    res[j++] = ls.get(m);
                    k--;
                }
            }
        }
        return res;
    }
}
