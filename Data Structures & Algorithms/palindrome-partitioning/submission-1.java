class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        divide(s, new ArrayList<>(), res);
        return res;
    }
    public void divide(String s, List<String> temp, List<List<String>> res){

        if(s.length() == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<s.length();i++){
            String sub = s.substring(0, i+1);
            if(check(sub)){
                temp.add(sub);
                divide(s.substring(i+1, s.length()), temp, res);
                temp.remove(temp.size() - 1);
            }

        }
    }
    public boolean check(String st){
        if(st.length() == 1) return true;
        int l=0, r = st.length()-1;
        while(l<r){
            if(st.charAt(l) != st.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
