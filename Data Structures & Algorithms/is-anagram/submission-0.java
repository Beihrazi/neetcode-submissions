class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int [] count = new int[26];
        //int[] ch = s.toCharArray();

        for(char st : s.toCharArray()){
            count[st - 'a']++;
        }

        for(char st : t.toCharArray()){
            count[st - 'a']--;
        }
        for(int i=0;i<count.length;i++){
            if(count[i] != 0) return false;
        }
        return true;
    }
}
