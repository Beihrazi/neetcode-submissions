class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            res.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] key : prerequisites){
            res.get(key[1]).add(key[0]);
            indegree[key[0]]++;
        }
        Queue<Integer> q =new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int idx = 0;
        int[] result = new int[numCourses];
        
        while(!q.isEmpty()){
            int c = q.poll();
            result[idx++] = c;

            for(int adj : res.get(c)){
                if(--indegree[adj] == 0){
                    q.offer(adj);
                }
            }
        }

        return idx == numCourses ? result : new int[0];
    }
}
