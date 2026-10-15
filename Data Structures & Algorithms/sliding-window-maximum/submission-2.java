class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
       
        int n = nums.length;
        int[] res = new int[n-k+1];

        int r=0, j=0;
        while(r<n){
            if(!dq.isEmpty() && dq.peekFirst() == r-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[r]){
                dq.pollLast();
            }
            dq.offerLast(r);
            if(r >= k-1){
                res[j++] = nums[dq.peekFirst()];
            }
            r++;
        }
        return res;
    }
}
