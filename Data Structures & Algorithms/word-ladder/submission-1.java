class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //checking if endword is present in wordlist
        if(!wordList.contains(endWord)) return 0;

        int count =0;
        for(String st : wordList){
            if(st.equals(endWord)) count++;
        }
        if(count == 0) return 0;

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.offer(beginWord);
        visited.add(beginWord);

        int res = 1;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                String st = q.poll();
            
                if(st.equals(endWord)) return res;

                for(String ls : wordList){
                    if(visited.contains(ls)) continue;

                    int len = check(st,ls);
                    if(len == st.length() - 1){
                        q.offer(ls);
                        visited.add(ls);
                    }
                }
            }
            res++;
        }
        return 0;
    }
    public int check(String st, String ls){
        int count =0;
        for(int i=0;i<st.length();i++){
            if(st.charAt(i) == ls.charAt(i)){
                count++;
            }
        }
        return count;
    }
}
