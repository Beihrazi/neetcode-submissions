class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        for(int i=0;i<strs.size();i++){
            String st = strs.get(i);
            int size = st.length();

            str += size + "#";
            str += st;
        }
        return str;
    }

    public List<String> decode(String str) {
        int l=0, r = 0, n = str.length();
        List<String> res = new ArrayList<>();

        while(r <n){
            char ch = str.charAt(r);
            if(ch == '#'){
                int size = Integer.parseInt(str.substring(l,r));
                l = r + 1 + size;
                res.add(str.substring(r+1,l));
                r= l;
            }
            r++;
        }
        return res;
    }
}
