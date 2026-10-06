class Solution {
    public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();

            boolean minusdiagonal[] = new boolean[2 * n-1];  
            boolean plusdiagonal[] = new boolean[2 * n-1];
            boolean column[] = new boolean[n];
            

            backtrack(n, 0, new ArrayList<>(), res, minusdiagonal, plusdiagonal, column);

            return res;  
    }

    public void backtrack(int n, int row, List<String> temp, List<List<String>> res, boolean[] minusdiagonal, boolean[] plusdiagonal, boolean[] col){

       
        for(int j=0;j<n;j++){
            if(row == n){
                res.add(new ArrayList<>(temp));
                return;
            }
            int minus = row - j + (n-1);
            int plus = row + j;
            if(col[j] == true || minusdiagonal[minus] == true || plusdiagonal[plus] == true) continue;
            String st = "";
            for(int i=0;i<n;i++){
                if(i == j){
                    st = st + "Q";
                }else{
                    st = st + ".";
                }
                
            }
            temp.add(st);

            col[j] = true;

            
            minusdiagonal[minus] = true;

            
            plusdiagonal[plus] = true;

            backtrack(n, row + 1, temp, res,minusdiagonal, plusdiagonal, col);

            col[j] = false;
            minusdiagonal[minus] = false;
            plusdiagonal[plus] = false;
      
            temp.remove(temp.size() - 1);

        }
    }
}
