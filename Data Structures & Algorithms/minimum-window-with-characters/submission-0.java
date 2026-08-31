class Solution {
    public String minWindow(String s, String t) {
        int minL = Integer.MAX_VALUE, l=0, r=0, start=0;

        Map<Character,Integer> required = new HashMap<>();
        for(char ch : t.toCharArray()){
            required.put(ch, required.getOrDefault(ch,0) + 1);
        }
        int requiredSize = required.size(), form=0;
        Map<Character,Integer> window = new HashMap<>();

        while(r<s.length()){
            char ch = s.charAt(r);
            window.put(ch, window.getOrDefault(ch,0)+1);

            if(required.containsKey(ch) && required.get(ch) == window.get(ch)){
                form++;
            }
            
            while(l<=r && form == requiredSize){
                if(r-l+1 < minL){
                    minL = r-l+1;
                    start = l;
                }
                char startLeft = s.charAt(l);
                window.put(startLeft, window.get(startLeft) - 1);
                
                if(required.containsKey(startLeft) && window.get(startLeft) < required.get(startLeft)){
                    form--;
                }
                l++;
            }
            r++;
        }

        return minL == Integer.MAX_VALUE ? "" : s.substring(start, start + minL);
    }
}
