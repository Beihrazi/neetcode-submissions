class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String st = strs[i];
            char[] ch = st.toCharArray();
            Arrays.sort(ch);
            String sortedKey = new String(ch);

            if(!hm.containsKey(sortedKey)){
                hm.put(sortedKey, new ArrayList<>());
            }
            hm.get(sortedKey).add(strs[i]);
        }
        List<List<String>> res = new ArrayList<>();

        for(List<String> val : hm.values()){
            res.add(val);
        }
        return res;
    }
}
