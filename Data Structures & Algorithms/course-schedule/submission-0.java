class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> hm = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            hm.put(i, new ArrayList<>());
        }
        for(int[] ls : prerequisites){
            int first = ls[0];
            int second = ls[1];
            hm.get(first).add(second);
        }
        Set<Integer> hs = new HashSet<>();
        for(int i=0;i<numCourses;i++){
            if(!dfs(i, hm, hs)) return false;
        }
        return true;
    }
    public boolean dfs(int course, Map<Integer, List<Integer>> hm, Set<Integer> hs){
        if(hs.contains(course)) return false;
        if(hm.get(course).isEmpty()) return true;

        hs.add(course);
        List<Integer> ls = hm.get(course);
        for(int i=0;i<ls.size();i++){
            if(!dfs(ls.get(i), hm,hs)) return false;
        }
        hs.remove(course);
        hm.get(course).clear();

        return true;
    }
}
