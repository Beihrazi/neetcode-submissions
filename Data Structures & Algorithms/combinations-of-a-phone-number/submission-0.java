class Solution {
    Map<Integer, String> hm = new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        
        hm.put(2, "abc");
        hm.put(3, "def");
        hm.put(4, "ghi");
        hm.put(5, "jkl");
        hm.put(6, "mno");
        hm.put(7, "pqrs");
        hm.put(8, "tuv");
        hm.put(9, "wxyz");

        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        
        backtrack(digits, 0, "", res);
        return res;
    }
    public void backtrack(String digits, int start, String temp, List<String> res){

        if(temp.length() == digits.length()){
            res.add(temp); //dg, dh, di,
            return;
        }
        String values = hm.get(digits.charAt(start) - '0');//3

        for(int i=0;i<values.length();i++){//def, 
            String ch = values.substring(i,i+1);//e

            backtrack(digits, start + 1, temp + ch, res);//e
        }
    }
}
