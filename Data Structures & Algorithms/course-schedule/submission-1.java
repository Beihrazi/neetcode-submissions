class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            ls.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        for(int[] pre : prerequisites){
            ls.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int pop = q.poll();
            for(int adj : ls.get(pop)){
                indegree[adj]--;
                if(indegree[adj] == 0){
                    q.offer(adj);
                }
            }
        }

        for(int i=0;i<numCourses;i++){
            if(indegree[i] != 0) return false;
        }
        return true;

    }
}
