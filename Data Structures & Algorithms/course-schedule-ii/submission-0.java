class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> hm = new HashMap<>();

        for(int i=0;i<numCourses;i++){
            hm.put(i, new ArrayList<>());
        }
        for(int[] res : prerequisites){
            int first = res[0];
            int second = res[1];

            hm.get(first).add(second);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> done = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            if(!dfs(i,res,hm,visited, done)) return new int[0];
        }
        int[] ans = new int[numCourses];
        
        for(int i=0;i<numCourses;i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    public boolean dfs(int course, List<Integer> res, Map<Integer, List<Integer>> hm, Set<Integer> visited, Set<Integer> done){

        if(done.contains(course)) return true;
        if(visited.contains(course)) return false;

        visited.add(course);
        List<Integer> ls = hm.get(course);

        for(int i=0;i<ls.size();i++){
            if(!dfs(ls.get(i), res, hm, visited, done)) return false;;
        }
        
        visited.remove(course);
        //no more neighbor
        done.add(course);

        //all neighbor completed
        res.add(course);
        return true;

    }
}
