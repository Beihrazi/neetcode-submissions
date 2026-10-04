class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        backtrack("",0,0, n, res);
        return res;
    }
    public void backtrack(String temp, int open, int close, int n, List<String> res){

        if(temp.length() == 2 * n){
            res.add(String.valueOf(temp));
            return;
        }
        if(open < n){
            backtrack(temp + "(", open + 1, close, n, res);
        }
        if(close < open){
            backtrack(temp + ")", open, close + 1, n, res);
        }
    }
}
