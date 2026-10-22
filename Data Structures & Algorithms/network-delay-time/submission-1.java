class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            graph.get(times[i][0]).add(new int[]{times[i][2], times[i][1]});
        }
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, k});

        Set<Integer> visited = new HashSet<>();
        int res = 0;
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int d = temp[0], node = temp[1];

            if(visited.contains(node)) continue;
            visited.add(node);
            res = d;

            for(int[] edge : graph.get(node)){
                int weight = edge[0], neighbour = edge[1];
                if(!visited.contains(neighbour)){
                    pq.offer(new int[]{weight + d, neighbour});
                }
            }
        }
        return visited.size() == n ? res : -1;
    }
}
