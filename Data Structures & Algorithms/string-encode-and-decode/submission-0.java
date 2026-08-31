class Solution {

    public String encode(List<String> strs) {
        int n = strs.size();
        StringBuilder sb = new StringBuilder();
        for(String st: strs){
            sb.append(st.length()+"#"+st);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ls = new ArrayList<>();
        int n = str.length(), i=0;
        while(i<n){
            int j = i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            ls.add(str.substring(j+1, j+1 + len));
            i = j+1 + len;
        }
        return ls;
    }
}
