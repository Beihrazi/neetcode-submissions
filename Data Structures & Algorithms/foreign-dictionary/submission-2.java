class Solution {
    public String foreignDictionary(String[] words) {
      int[] indegree = new int[26];
      Map<Character, List<Character>> adj = new HashMap<>();
      Queue<Character> pq = new PriorityQueue<>();

      for(String  st : words){
        for(char ch : st.toCharArray()){
            adj.computeIfAbsent(ch, t -> new ArrayList<>());
        }
      }
      int n = words.length;
      for(int i=0;i<n-1;i++){
        if(!compare(words[i], words[i+1], adj, indegree)) return "";
      }
      for(char key : adj.keySet()){
        if(indegree[key - 'a'] == 0){
            pq.offer(key);
        }
      }
    StringBuilder res = new StringBuilder();

      while(!pq.isEmpty()){
        char cur = pq.poll();
        res.append(cur);
        
        for(char temp : adj.get(cur)){
            indegree[temp - 'a']--;
            if(indegree[temp - 'a'] == 0){
                pq.offer(temp);
            }
        }
      }
      //cycle detection
      if(res.length() != adj.size()) return "";
      return res.toString();
    }

    public boolean compare(String first, String second, Map<Character, List<Character>> adj, int[] indegree){
        int i=0;
        while(i<first.length() && i<second.length()){

            char fc = first.charAt(i), sc = second.charAt(i);

            if(fc != sc){
                adj.get(fc).add(sc);
                indegree[sc - 'a']++;
                return true;
            }
            i++;
        }
        if(i == second.length() && first.length() > second.length()) return false;;

        return true;
    }
}
