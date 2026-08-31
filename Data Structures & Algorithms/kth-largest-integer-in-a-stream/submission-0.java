class KthLargest {
    PriorityQueue<Integer> pq;
    int kth = 0;

    public KthLargest(int k, int[] nums) {
        this.kth = k;
        pq = new PriorityQueue<>();
        for(int ele : nums){
            pq.add(ele);
            if(pq.size() > k){
                pq.poll();
            }
        }  
    }
    
    public int add(int val) {
        pq.add(val);
        
        if(pq.size() > kth){
            pq.poll();
        }
        return pq.peek();
    }
}
