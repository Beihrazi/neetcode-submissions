class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hs = new HashSet<>();
        int max=0, l=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            while(hs.contains(ch)){
                hs.remove(s.charAt(l++));
            }
            hs.add(ch);
            max = Math.max(max, i-l+1);
        }
        return max;
    }
}
