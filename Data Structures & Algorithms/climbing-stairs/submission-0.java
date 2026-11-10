class Solution {
    public int climbStairs(int n) {
        //top down recursion with memoization
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);

        // return fn(0, n, dp);
        return fn(n);
    }
    public int fn(int n){
        int one = 1, two = 1;
        for(int i=0;i<n-1;i++){
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;

    }
    public int fn(int i, int n, int[] dp){
        if(i > n) return 0;
        if(i == n) return 1;

        if(dp[i] != -1) return dp[i];
        int one = fn(i+1, n, dp);
        int two = fn(i+2, n, dp);

        dp[i] = one + two;
        return dp[i];
    }
}
