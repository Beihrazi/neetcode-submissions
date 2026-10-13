class Solution {
    public int[] findRedundantConnection(int[][] edges) {
         int[] parent = new int[edges.length + 1];

         for(int i=1;i<parent.length;i++){
            parent[i] = i;
         }
         for(int[] ed : edges){
            int roota = find(ed[0], parent[ed[0]], parent);
            int rootb = find(ed[1], parent[ed[1]], parent);

            if(roota != rootb){
                parent[rootb] = roota;
            }else{
                return ed;
            }
         }
         return new int[]{0,0};
    }
    public int find(int num, int par, int[] parent){

        if(num == par) return num;
        int x = par;
        return find(x, parent[x], parent);
        
    }
}
