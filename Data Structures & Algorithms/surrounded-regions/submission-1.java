class Solution {
    public void solve(char[][] board) {
        int row=board.length;
        int col=board[0].length;
        boolean[][] mark = new boolean[row][col];

        for(int i=0;i<col;i++){
            dfs(0,i, board, mark, row, col);//top
            dfs(row-1,i,board, mark, row, col);//bottom 
        }
        for(int i=0;i<row;i++){
            dfs(i,0,board, mark, row, col);//left
            dfs(i,col-1,board,mark, row, col);//right
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mark[i][j] == false) board[i][j] = 'X';
            }
        }
    }
    public void dfs(int r, int c, char[][] board, boolean[][] mark, int row, int col){
        if(r < 0 || r >= row || c < 0 || c>= col) return;
        if(board[r][c] == 'X' || mark[r][c] == true) return;
        
        mark[r][c] = true;

        dfs(r+1,c,board,mark,row,col);
        dfs(r-1,c,board,mark,row,col);
        dfs(r,c-1,board,mark,row,col);
        dfs(r,c+1,board,mark,row,col);

    }
}
