class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for(int i = 1; i <= n; i++) g.put(i, new HashSet<>());
        
        for(int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n + 1];
            g.get(edges[i][0]).add(edges[i][1]);
            g.get(edges[i][1]).add(edges[i][0]);
            if(hasCycle(g, edges[i][0], -1, visited)) return edges[i];
        }
        return new int[]{};
    }

    public boolean hasCycle(Map<Integer, Set<Integer>> g, int node, int prevNode, boolean[] visited) {
        if(visited[node]) return true;
        
        visited[node] = true;
        for(int nextNode : g.get(node)) {
            if(nextNode == prevNode) continue;
            if(hasCycle(g, nextNode, node, visited)) return true;
        }
        return false;
    }
}
