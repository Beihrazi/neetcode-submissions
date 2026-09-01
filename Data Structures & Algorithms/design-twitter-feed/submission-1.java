class Twitter {

    private int time = 0;
    Map<Integer, List<int[]>> pt = new HashMap<>();
    Map<Integer, Set<Integer>> follow = new HashMap<>();

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        pt.putIfAbsent(userId, new ArrayList<>());
        pt.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));

        Set<Integer> people = new HashSet<>();
        people.add(userId);
        if(follow.containsKey(userId)){
            people.addAll(follow.get(userId));
        }

        for(int person : people){
            List<int[]> tweets = pt.get(person);
            if(tweets == null) continue;
            for(int[] tweet : tweets){
                pq.add(tweet);
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty() && res.size() < 10){
            int[] tweet = pq.poll();
            res.add(tweet[1]);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        follow.putIfAbsent(followerId, new HashSet<>());
        follow.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        follow.get(followerId).remove(followeeId);
    }
}
