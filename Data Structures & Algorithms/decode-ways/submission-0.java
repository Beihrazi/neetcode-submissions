class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return fn(0,s, dp);
    }
    //226
    public int fn(int i,String s, int[] dp){
        if(i >= s.length()) return 1;
        if(s.charAt(i) == '0') return 0;

        if(dp[i] != -1) return dp[i];
        int one = fn(i+1, s, dp);
        int two = 0;

        if(i+1 < s.length()){

            String num = s.substring(i,i+2);
            int convert = Integer.parseInt(num);
            if(convert >= 10 && convert <= 26){
                two = fn(i+2, s, dp);
            }
        }

        dp[i] = one + two;
        return dp[i];
    }
}
