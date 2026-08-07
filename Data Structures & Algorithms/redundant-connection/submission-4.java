class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for(int i = 1; i <= n; i++) g.put(i, new HashSet<>());
        
        int[] indegrees = new int[n + 1];
        for(int i = 0; i < n; i++) {
            int[] e = edges[i];
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
            indegrees[e[0]]++;
            indegrees[e[1]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(indegrees[i] == 1) que.offer(i);
        }

        while(!que.isEmpty()) {
            int node = que.poll();
            for(int nextNode : g.get(node)) {
                indegrees[nextNode]--;
                if(indegrees[nextNode] == 1) que.offer(nextNode);
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            int[] e = edges[i];
            if(indegrees[e[0]] > 1 && indegrees[e[1]] > 1) return e;
        }
        return new int[]{};
    }
}
