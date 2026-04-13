class Twitter {
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<List<Integer>>> tweetMap;
    int count;
    public Twitter() {
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
        this.count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, key-> new ArrayList<>()).add(List.of(count, tweetId));
        count ++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        followMap.computeIfAbsent(userId, key -> new HashSet<>()).add(userId);
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(
            (a,b) -> b.get(0) - a.get(0)
        );

        for (int followeeId : followMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                int index = tweetMap.get(followeeId).size() - 1;
                if (index >= 0) {
                    List<Integer> ct = tweetMap.get(followeeId).get(index);
                    maxHeap.add(List.of(ct.get(0), ct.get(1), followeeId, index-1));
                }
            }
        }

        List<Integer> feed = new ArrayList<>();
        while(feed.size() < 10 && !maxHeap.isEmpty()) {
            List<Integer> ctfi = maxHeap.poll();
            feed.add(ctfi.get(1));
            if (ctfi.get(3) >= 0) {
                List<Integer> ct = tweetMap.get(ctfi.get(2)).get(ctfi.get(3));
                maxHeap.add(List.of(ct.get(0), ct.get(1), ctfi.get(2), ctfi.get(3)-1));
            }
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, key -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
