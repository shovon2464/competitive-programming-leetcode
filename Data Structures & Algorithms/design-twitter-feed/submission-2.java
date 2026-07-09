class Twitter {

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> tweetMap;
    int time;
    public Twitter() {
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
        this.time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, key -> new ArrayList<>()).add(new int[]{tweetId, time});
        time ++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> following = new ArrayList<>();
        following.add(userId);
        for (int f : followMap.getOrDefault(userId, new HashSet<>())) {
            following.add(f);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> (b[1] - a[1])
        );

        for (int f : following) {
            List<int[]> tweets = tweetMap.get(f);
            if (tweets == null || tweets.size() == 0) continue;
            int tweetsNum = tweets.size();
            int[] lastTweet = tweets.get(tweetsNum - 1);
            maxHeap.offer(new int[]{lastTweet[0], lastTweet[1], f, tweetsNum - 2});
        }

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty() && result.size() < 10) {
            int[] c = maxHeap.poll();
            result.add(c[0]);

            if (c[3] >= 0) {
                List<int[]> tweets = tweetMap.get(c[2]);
                if (tweets == null || tweets.size() == 0) continue;
                int[] lastTweet = tweets.get(c[3]);
                maxHeap.offer(new int[]{lastTweet[0], lastTweet[1], c[2], c[3] - 1});
            }
        }

        return result;
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
