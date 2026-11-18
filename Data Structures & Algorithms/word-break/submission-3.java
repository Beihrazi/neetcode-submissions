class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return fn(0, s, wordDict, dp);
    }
    public boolean fn(int i,String s, List<String> wordDict, Boolean[] dp){
        int n = s.length();
        if(i == n) return true;

        if(dp[i] != null) return dp[i];

        for(String word : wordDict){
            int len = word.length();
            int j = i+ len;
            if(j <= n){
                String st = s.substring(i, j);

                if(word.equals(st)){
                    if(fn(j, s, wordDict, dp)){
                        dp[i] = true;
                        return dp[i];
                    }
                }
            }
        }
        dp[i] = false;
        return dp[i];
    }
}
