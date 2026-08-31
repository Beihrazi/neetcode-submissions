class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] square = new boolean[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch = board[i][j];
                if(ch == '.') continue;

                int num = ch-'1';
                int index = (i/3)*3+(j/3);

                if(row[i][num] || col[j][num] || square[index][num]) return false;

                row[i][num] = col[j][num] = square[index][num] = true;
                
            }
        }
        return true;
    }
}
