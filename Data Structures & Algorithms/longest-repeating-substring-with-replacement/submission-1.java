class Solution {
    public int characterReplacement(String s, int k) {
        int[] nums = new int[26];
        int res=0, l=0, mosfq=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            nums[s.charAt(i) - 'A']++;
            mosfq = Math.max(mosfq, nums[s.charAt(i) - 'A']);
            while(i-l+1 - mosfq > k){
                nums[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, i-l+1);
        }
        return res;
    }
}
