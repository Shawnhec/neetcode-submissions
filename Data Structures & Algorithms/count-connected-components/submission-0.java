class Solution {
    public int countComponents(int n, int[][] edges) {
        int ans = 0;
        Map<Integer, Set<Integer>> g = new HashMap<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            g.put(i, new HashSet<>());
        }
        for(int i = 0; i < edges.length; i++) {
            g.get(edges[i][0]).add(edges[i][1]);
            g.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            dfs(i, -1, g, visited);
            ans++;
        }
        return ans;
    }

    public void dfs(int node, int parent, Map<Integer, Set<Integer>> g, boolean[] visited) {
        if(visited[node]) return;

        visited[node] = true;
        for(int nextNode : g.get(node)) {
            if(nextNode == parent) continue;
            dfs(nextNode, node, g, visited);
        }
    }
}
