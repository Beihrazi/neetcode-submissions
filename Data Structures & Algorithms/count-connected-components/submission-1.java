class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int[] ed : edges){
            ls.get(ed[1]).add(ed[0]);
            ls.get(ed[0]).add(ed[1]);
        }
        Set<Integer> done = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        int count = 0;
        for(int i=0;i<n;i++){
            if(done.contains(i)){
                continue;
            }else{
                count++;
                dfs(i,-1,visited,done,ls);
            }
        }
        return count;
    }
    public void dfs(int node, int parent, Set<Integer> visited, Set<Integer> done, List<List<Integer>> ls){

        if(visited.contains(node)) return;

        visited.add(node);
        for(int ele : ls.get(node)){
            if(ele == parent) continue;
            dfs(ele, node, visited, done, ls);
        }
        done.add(node);
       
    }
}
