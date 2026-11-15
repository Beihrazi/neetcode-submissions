class Solution {
    int start =0, reslen = 0;

    public String longestPalindrome(String s) {
        int n = s.length();

        for(int i=0;i<n;i++){
            fn(i,i,s,n);
            fn(i, i+1, s,n);
        }

        return s.substring(start, start + reslen);
    }
    public void fn(int l, int r, String s, int n){
        
         while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > reslen){
                    reslen = r-l+1;
                    start = l;
                }
                l--;
                r++;
            }
    }
}
