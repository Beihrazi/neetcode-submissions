class Solution {
    
    public int orangesRotting(int[][] grid) {
        Queue<List<Integer>> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new ArrayList<>(List.of(i,j)));
                }
            }
        }
        int count = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                List<Integer> ls = q.poll();
                int row = ls.get(0);
                int col = ls.get(1);

                check(row + 1, col, grid,m,n, q);
                check(row - 1, col, grid,m,n, q);
                check(row, col + 1, grid,m,n, q);
                check(row, col - 1, grid,m,n, q);
            }
            if(!q.isEmpty()){
                count++;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1)return -1;
            }
        }
        return count;
    }
    public void check(int r, int c, int[][] grid, int m, int n, Queue<List<Integer>> q){
        if(r < 0 || r >= m || c < 0 || c>= n) return;
        if(grid[r][c] == 0 || grid[r][c] == 2) return;

        if(grid[r][c] == 1){
            grid[r][c] = 2;
            q.add(new ArrayList<>(List.of(r,c)));
        }
        
    }
}
