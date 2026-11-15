class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        int reslength = 0;
        String res = "";

        for(int i=0;i<n;i++){
            //odd
            int l=i,r=i;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > reslength){
                    reslength = r-l+1;
                    res = s.substring(l,r+1);
                }
                l--;
                r++;
            }

            //even
            l=i;
            r=i+1;
             while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > reslength){
                    reslength = r-l+1;
                    res = s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }
        return res;
    }
}
