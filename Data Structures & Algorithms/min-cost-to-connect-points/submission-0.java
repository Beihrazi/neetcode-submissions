class Solution {
    public int minCostConnectPoints(int[][] points) {
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

        // int weight = points[0][0] + points[0][1];
        pq.offer(new int[]{0,0});
        int res = 0, count = 0;

        while(!pq.isEmpty()){
            if(count == points.length){
                return res;
            }

            int[] temp = pq.poll();
            int cost = temp[0], edge = temp[1];

            if(visited.contains(edge)) continue;
            visited.add(edge);
            res += cost;
            count++;

            for(int i=0;i<points.length;i++){
                if(visited.contains(i)) continue;

                int weightCost = Math.abs(points[edge][0] - points[i][0]) + Math.abs(points[edge][1] - points[i][1]);
                pq.offer(new int[]{weightCost, i});
            }
        }

        return res;
        
    }
}
