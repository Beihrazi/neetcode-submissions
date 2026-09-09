class Pair{
    private int time;
    private String val;

    public Pair(int time, String val){
        this.time = time;
        this.val = val;
    }
}

class TimeMap {
    Map<String, List<Pair>> hm = new HashMap<>();

    public TimeMap() {
        
    }
   
    public void set(String key, String value, int timestamp) {
        hm.computeIfAbsent(key, k -> new ArrayList<>());
        hm.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = hm.get(key);
        if(list == null) return "";
        
        int low = 0, high = list.size() - 1;
        int res = -1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(list.get(mid).time <= timestamp){
                res = mid;
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }
        return (res == -1 ? "" :  list.get(res).val);

    }
}
