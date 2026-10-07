class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean [][]visited = new boolean[row][col];
        int count = 0;
        int result = 0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
               int res =  dfs(i,j,row,col,visited,grid, count);
               result = Math.max(result, res);
            }
        }
        return result;
    }
    public int dfs(int r, int c, int m, int n, boolean[][] visited, int[][] grid, int count){
        if(r < 0 || r >= m || c < 0 || c >= n) return count;
        if(grid[r][c] == 0) return count;
        if(visited[r][c]) return count;

        visited[r][c] = true;
        count++;

        count = dfs(r+1, c, m,n,visited,grid, count); //1 or 0
        count = dfs(r-1, c, m,n,visited,grid, count);
        count = dfs(r, c+1, m,n,visited,grid, count);
        count = dfs(r, c-1, m,n,visited,grid, count);

        return count;
    }
}
