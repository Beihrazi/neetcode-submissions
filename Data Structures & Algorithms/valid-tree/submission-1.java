class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            ls.get(edge[0]).add(edge[1]);
            ls.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
      
        if(!dfs(0, -1, ls,visited)) return false;
        if(visited.size() != n) return false;
        return true;
    }
    public boolean dfs(int i,int parent,List<List<Integer>> ls, Set<Integer> visited){
        if(visited.contains(i)) return false;

        visited.add(i);
        for(int neig : ls.get(i)){
            if(neig == parent) continue;
            if(!dfs(neig, i, ls, visited)) return false; 
        }
        return true;
    }
}
