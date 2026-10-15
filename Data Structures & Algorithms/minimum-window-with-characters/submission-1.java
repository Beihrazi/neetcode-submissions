class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        int[] have = new int[128];
        
        int n = t.length();
        for(int i=0;i<n;i++){
            need[t.charAt(i)]++;
        }
        int formed = 0, bestlen = Integer.MAX_VALUE, beststart = 0, l=0;

        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);
            have[ch]++;

            if(have[ch] <= need[ch]){
                formed++;
            }

            while(formed == n){
                if(i-l+1 < bestlen){
                    beststart = l;
                    bestlen = i-l+1;
                }
                have[s.charAt(l)]--;
                if(have[s.charAt(l)] < need[s.charAt(l)]) formed--;
                l++;
            }
        }
        if(bestlen == Integer.MAX_VALUE) return "";
        return s.substring(beststart, beststart + bestlen);
        
    }
}
