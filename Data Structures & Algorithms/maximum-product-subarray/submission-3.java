class Solution {
    public int maxProduct(int[] nums) {
        int minp =1, maxp = 1, ans = Integer.MIN_VALUE;
        for(int i: nums){
            if(i == 0){
                ans = Math.max(ans, 0);
                maxp = 1;
                minp = 1;
                continue;
            }
            int extendedMin = minp * i; //-2,-6,24
            int extendedMax = maxp * i; //-2,3,-12

            int tempmax =  Math.max(i, Math.max(extendedMin, extendedMax)); //-2,3,24
            int tempmin =  Math.min(i, Math.min(extendedMin, extendedMax)); //-2,-6,-12

        maxp = tempmax;
        minp = tempmin;
        ans = Math.max(ans, maxp);
        }

        return ans;
    }
}
