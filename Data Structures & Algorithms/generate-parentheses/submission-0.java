class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder temp = new StringBuilder();
        List<String> res = new ArrayList<>();
        backtrack(temp,0,0, n, res);
        return res;
    }
    public void backtrack(StringBuilder temp, int open, int close, int n, List<String> res){

        if(temp.length() == 2 * n){
            res.add(String.valueOf(temp));
            return;
        }
        if(open < n){
            temp.append("(");
            backtrack(temp, open + 1, close, n, res);
            temp.deleteCharAt(temp.length() - 1);
        }
        if(close < open){
            temp.append(")");
            backtrack(temp, open, close + 1, n, res);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
