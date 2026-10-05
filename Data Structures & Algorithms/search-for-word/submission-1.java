class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;

        boolean[][] marked = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                boolean found = dfs(board, word, 0, i, j, n, m, marked);
                if(found) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word,  int k, int row, int col, int n, int m, boolean[][] marked){
        
        if(k == word.length()) return true;

        //bound check
        if(row < 0 || row > n-1 || col > m-1 || col < 0) return false;
        if(board[row][col] != word.charAt(k) || marked[row][col] == true) return false;

        if(board[row][col] == word.charAt(k)){
            marked[row][col] = true;
        }
        boolean found = dfs(board, word, k+1, row + 1, col, n,m, marked) || dfs(board, word, k+1, row - 1, col, n,m, marked)  || dfs(board, word, k+1, row, col + 1, n,m, marked) || dfs(board, word, k+1, row, col-1, n,m, marked);

        if(!found){
            marked[row][col] = false;
        }
        return found;
    }
}
