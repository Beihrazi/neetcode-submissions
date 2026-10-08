class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        //row 0
        for(int i=0;i<col;i++){
        dfs(heights[0][i], 0, i, heights, pacific,row,col, true, false); 
        dfs(heights[row-1][i], row-1,i, heights, atlantic,row,col, false, true);
        }
        //column 0
        for(int i=0;i<row;i++){
            dfs(heights[i][0], i,0, heights, pacific,row,col, true, false); 
            dfs(heights[i][col-1], i, col-1, heights, atlantic,row,col, false, true);
        }
      
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pacific[i][j] == true && atlantic[i][j] == true){
                    res.add(new ArrayList<>(List.of(i,j)));
                }
            }
        }
        return res;
    }
    public void dfs(int cur, int r, int c, int[][] heights, boolean[][] seen, int n, int m, boolean pac, boolean atl){
        if(r<0 || c<0 || r>=n || c >= m) return;
        if(seen[r][c] == true) return;

        int neighbor = heights[r][c];
        if(neighbor >= cur){
           seen[r][c] = true;
        }else{
            return;
        }
        dfs(neighbor, r+1, c, heights, seen, n, m, pac, atl);
        dfs(neighbor, r-1, c, heights, seen, n, m, pac, atl);
        dfs(neighbor, r, c+1, heights, seen, n, m, pac, atl);
        dfs(neighbor, r, c-1, heights, seen, n, m, pac, atl);
    }

}
