class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hs = new HashSet<>();
        int l=0,res=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            while(hs.contains(ch)){
               hs.remove(s.charAt(l++));
            }
            hs.add(ch);
            res = Math.max(res, hs.size());

        }
        return res;
    }
}
