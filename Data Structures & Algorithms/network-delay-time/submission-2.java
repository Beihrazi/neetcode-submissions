class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        int[] dist = new int[n+1];  //shortes distance from the source to every other vertex
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] parent = new int[n+1]; //shortest distance known so far

        for(int i=0;i<=n;i++){
            adj.computeIfAbsent(i, t -> new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int u = times[i][0] , v = times[i][1], w = times[i][2];
            adj.get(u).add(new int[]{w,v});
        }
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        dist[k] = 0;
        pq.add(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int w = temp[0], v = temp[1];

            if(w > dist[v]) continue; //skip if new weight is greater than known distance so far
            for(int[] key : adj.get(v)){
                int nw = key[0], nv = key[1];

                int distance = dist[v] + nw;
                if(distance < dist[nv]){
                    pq.add(new int[]{distance,nv});
                    dist[nv] = distance;
                    parent[nv] = v;
                }
            }

        }

        int max = 0;
        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}
