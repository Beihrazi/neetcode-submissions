class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        //row
        for(int i=0;i<row;i++){
            Set<Character> rowset = new HashSet<>();
            for(int j=0;j<col;j++){
                if(board[i][j] == '.') continue;
                if(rowset.contains(board[i][j])) return false;
                rowset.add(board[i][j]);
            }
        } 
        //col
        for(int j=0;j<col;j++){
            Set<Character> colset = new HashSet<>();
            for(int i=0;i<row;i++){
                if(board[i][j] == '.') continue;
                if(colset.contains(board[i][j])) return false;
                colset.add(board[i][j]);
            }
        }

        //3x3 matrix
        Map<List<Integer>, Set<Character>> hm = new HashMap<>();
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j] == '.') continue;

                List<Integer> key = List.of(i/3, j/3); //(0,0)
                if(!hm.containsKey(key)){
                    hm.put(key, new HashSet<>());
                }
                if(hm.get(key).contains(board[i][j])) return false;
                hm.get(key).add(board[i][j]);
            }
        }

        return true;
    
    }
}
