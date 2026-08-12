class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Set<int[]>> g = new HashMap<>();
        for(int i = 0; i < n; i++) g.put(i, new HashSet<>());
        
        for(int i = 0; i < flights.length; i++) {
            int[] flight = flights[i];
            g.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int[] prices = new int[n];

        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0; 

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{src, 0});
        for(int i = 0; i <= k; i++) {
            int size = que.size();
            for(int j = 0; j < size; j++) {
                int[] leaving = que.poll();
                int node = leaving[0];
                int dist = leaving[1];

                if(node == dst) {
                    prices[dst] = Math.min(prices[dst], dist);
                }

                for(int[] e : g.get(node)) {
                    if(e[1] + dist > prices[e[0]]) continue;
                    que.offer(new int[]{e[0], e[1] + dist});
                    prices[e[0]] = Math.min(prices[e[0]], e[1] + dist);
                }
            }
            
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
