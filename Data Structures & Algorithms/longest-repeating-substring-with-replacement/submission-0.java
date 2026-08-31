class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];

        int maxL=0, mostF = 0, l=0, res=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            count[ch-'A']++;
            mostF = Math.max(mostF, count[ch-'A']);
            if(i-l+1 - mostF>k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, i-l+1);
        }
        return res;
    }
}
