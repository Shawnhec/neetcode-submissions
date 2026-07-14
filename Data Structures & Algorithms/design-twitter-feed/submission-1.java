class Twitter {

    private int time;
    private Map<Integer, Set<Integer>> followingGraph;
    private Map<Integer, List<int[]>> tweetGraph;

    public Twitter() {
        this.time = 0;
        this.followingGraph = new HashMap<>();
        this.tweetGraph = new HashMap<>();
        for(int userId = 1; userId <= 100; userId++) {
            followingGraph.put(userId, new HashSet<>());
            tweetGraph.put(userId, new ArrayList<>());
        }
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetGraph.get(userId).add(new int[]{tweetId, time});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> userNewsFeed = new ArrayList<>();
        for(int[] userTweet : tweetGraph.get(userId)) {
            userNewsFeed.add(userTweet);
        }
        for (int userFollowing : followingGraph.get(userId)) {
            for (int[] userFollowingTweet : tweetGraph.get(userFollowing)) {
                userNewsFeed.add(userFollowingTweet);
            }
        }

        Collections.sort(userNewsFeed, (a, b) -> b[1] - a[1]);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < userNewsFeed.size(); i++) {
            if(i == 10) break;
            ans.add(userNewsFeed.get(i)[0]);
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
         if (followerId == followeeId) return;
        followingGraph.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followingGraph.get(followerId).remove(followeeId);
    }
}
