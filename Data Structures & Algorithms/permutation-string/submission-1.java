class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] num1 = new int[26];
        int[] num2 = new int[26];

        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            num1[ch - 'a']++;
        }
        int n = s1.length();
        int n2 = s2.length() - n;
        for(int i=0;i<=n2;i++){

            int  l = i;
            while(l < n+i){
                num2[s2.charAt(l) - 'a']++;
                l++;
            }
            if(Arrays.equals(num1, num2)) return true;
            Arrays.fill(num2, 0);
        }
        return false;
    }
}
