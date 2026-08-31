class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> {
                int disA = ((a[0] * a[0]) + (a[1] * a[1]));
                int disB = ((b[0]*b[0]) + (b[1]*b[1]));
            return disB - disA;
            }
        );
        for(int[] i : points){
            pq.add(i);

            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.toArray(new int[0][]);
    }
}
