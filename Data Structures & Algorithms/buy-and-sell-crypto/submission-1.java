class Solution {
    public int maxProfit(int[] prices) {
        int s = prices[0],r=0, max=0;
        while(r<prices.length){
           
            if(prices[r] <= s){
                s = prices[r];
            }
            max = Math.max(max, prices[r] - s);
            r++;
        }
        return max;
    }
}
