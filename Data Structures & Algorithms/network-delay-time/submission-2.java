class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Set<int[]>> g = new HashMap<>();
        int[] shortestPath = new int[n + 1];
        Arrays.fill(shortestPath, Integer.MAX_VALUE / 2);
        for(int i = 1; i <= n; i++) g.put(i, new HashSet<>());
        for(int[] time : times) {
            g.get(time[0]).add(new int[]{time[1], time[2]});
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        shortestPath[k] = 0;

        int visitCnt = 0;
        int ans = 0;
        while(!pq.isEmpty())  {
            int[] leaving = pq.poll();
            int currNode = leaving[0];
            int dis = leaving[1];
            if(dis > shortestPath[currNode]) continue;
            visitCnt++;
            ans = dis;


            for(int[] e : g.get(currNode)) {
                if(e[1] + dis >= shortestPath[e[0]]) continue;
                pq.offer(new int[]{e[0], e[1] + dis});
                shortestPath[e[0]] = e[1] + dis; 
            }
        }

        return visitCnt == n ? ans : -1;
    }

    
}