class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l=0,r=0, n=nums.length;
        int res[] = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();

        while(r<n){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[r]){
                dq.pollLast();
            }
            dq.offerLast(r);
            
            if(dq.peekFirst() < l){
                dq.pollFirst();
            }
            if(r+1 >= k){
                res[l] = nums[dq.peekFirst()];
                l++;
            }
            r++;
        }
        return res;
    }
}
