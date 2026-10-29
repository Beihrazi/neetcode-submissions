class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i=0;i<=k;i++){
            int[] temp = dist.clone();

            for(int[] fl : flights){
                int from = fl[0], to = fl[1], cost = fl[2];

                if(dist[from] != Integer.MAX_VALUE){
                    temp[to] = Math.min(dist[from] + cost, temp[to]);
                }
            }
            dist = temp;
        }

        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}
