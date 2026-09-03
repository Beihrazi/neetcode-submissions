class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, res = Integer.MAX_VALUE;

        int high = Integer.MIN_VALUE;
        for(int i: piles){
            high = Math.max(high, i);
        }
        while(low <= high){
            int k = low + (high-low)/2;
            int hours =0;
            
            for(int i: piles){
                int ceil = (i + k -1)/k;
                hours += ceil;
            }
            if(hours <= h){
                res = Math.min(res, k);
                high = k-1;
            }else{
                low = k+1;
            }
        }
        return res;

    }
    
}
