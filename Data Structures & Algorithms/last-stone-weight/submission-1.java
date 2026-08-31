class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int i : stones){
            pq.add(i);
        }

        //6,4,3,2,2
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();

            if(first > second){
                int diff = first - second;
                pq.add(diff);
            }else if(first == second){
                continue;
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();

    }
}
