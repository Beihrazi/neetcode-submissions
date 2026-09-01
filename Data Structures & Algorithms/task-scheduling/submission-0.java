class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> hm = new HashMap<>();
        for(char ch : tasks){
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(char i : hm.keySet()){
            pq.add(hm.get(i));
        }

        List<Integer> temp = new ArrayList<>();
        int count = 0;
        
        while(!pq.isEmpty()){
            for(int i=0;i<=n;i++){
                if(!pq.isEmpty()){
                    int pop = pq.poll();
                    count++;
                    pop--;
                    if(pop != 0){
                        temp.add(pop);
                    }
                }else if(!temp.isEmpty()){
                    count++;
                }
                
            }
            for(int ele: temp){
                pq.add(ele);
            }
            temp.clear();
        }
        return count;
    }
}
