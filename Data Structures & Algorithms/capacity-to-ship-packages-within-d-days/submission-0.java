class Solution {

    //10 - 26 ; 18, 13
    //1,3,5 : 7,8,9
    //d - 1
    public int shipWithinDays(int[] weights, int days) {
        int maxP = Integer.MIN_VALUE, res = Integer.MAX_VALUE, sum=0;
        for(int i : weights){
            maxP = Math.max(i, maxP);
            sum += i;
        }
        int low = maxP, high = sum;

        while(low<=high){
            int capacity = low + (high-low)/2;
            int total = 0, count = 1;

            for(int i = 0;i<weights.length;i++){
                total += weights[i];
                if(total > capacity){
                    count++;
                    total = weights[i];
                }
            }
            if(count <= days){
                res = Math.min(capacity, res);
                high = capacity - 1;
            }else{
                low = capacity + 1;
            }
        }
        return res;
    }
    //c=3
    //10
}