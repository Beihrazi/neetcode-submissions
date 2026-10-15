class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        int[] num1 = new int[26];
        int[] num2 = new int[26];

        for(int i=0;i<s1.length();i++){
            num1[s1.charAt(i) - 'a']++;
            num2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(num1, num2)) return true;
        int n = s1.length();

        for(int i=n;i<s2.length();i++){
            num2[s2.charAt(i) - 'a']++;
            num2[s2.charAt(i-n) - 'a']--;

            if(Arrays.equals(num1, num2)) return true;
        }
        
        return false;
    }
}
