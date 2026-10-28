class Solution {
    public int swimInWater(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

        pq.add(new int[]{grid[0][0], 0,0});
        int[][] dist = {{0,1},{1,0},{-1,0},{0,-1}}; //frontier
        visited[0][0] = true;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cost = cur[0], r = cur[1], c = cur[2];

            if(r == row-1 && c == col-1) return cost;

            for(int[] temp : dist){
                int nr = r + temp[0], nc = c + temp[1];
                if(nr >= row || nr < 0 || nc >= col || nc < 0 || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                pq.offer(new int[]{Math.max(cost, grid[nr][nc]), nr,nc});
            }
        }
        return -1;

    }
}
