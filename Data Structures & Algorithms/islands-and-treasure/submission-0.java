class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<List<Integer>> q = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 0){
                    q.add(new ArrayList<>(List.of(i,j)));
                }  
            }
        }
        while(!q.isEmpty()){
            List<Integer> pop = q.poll();
            int i = pop.get(0);
            int j = pop.get(1);
            check(grid, i - 1, j, row, col, q, grid[i][j]);
            check(grid, i, j - 1, row, col, q, grid[i][j]);
            check(grid, i + 1, j, row, col, q, grid[i][j]);
            check(grid, i, j + 1, row, col, q, grid[i][j]);
        }
    }
    public void check(int[][] grid, int r, int c, int m, int n, Queue<List<Integer>> q, int near){
        int inf = Integer.MAX_VALUE;

        if(r < 0 || r >= m || c < 0 || c>= n) return;

        if(grid[r][c] == inf && near == 0){
            grid[r][c] = 1;
        q.add(new ArrayList<>(List.of(r,c)));

        }else if(grid[r][c] == inf){
            grid[r][c] = 1;
            grid[r][c] += near;
        q.add(new ArrayList<>(List.of(r,c)));

        }
    }
}
