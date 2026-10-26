class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> map = new HashMap<>();
        for(List<String> ls : tickets){
            map.computeIfAbsent(ls.get(0), k -> new PriorityQueue<>((a,b) -> a.compareTo(b))).add(ls.get(1));
        }
        List<String> res = new ArrayList<>();
        List<String> result = dfs("JFK", map, res);
        Collections.reverse(result);
        return result;
    
    }
    public List<String> dfs(String st, Map<String, Queue<String>> map, List<String> res){
        
        while(map.containsKey(st) && !map.get(st).isEmpty()){
            String temp = map.get(st).poll();
            dfs(temp, map, res);
        }
        res.add(st);

        return res;
        
    }
}
