class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for(int i = 1; i <= n; i++) g.put(i, new HashSet<>());

        for(int i = 0; i < n; i++) {
            int[] e = edges[i];
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        
        Set<Integer> cycleNodes = new HashSet<>();
        boolean[] visited = new boolean[n + 1];
        int[] cycleStart = new int[1];
        hasCycle(g, 1, -1, visited, cycleNodes, cycleStart);
        
        for(int i = n - 1; i >= 0; i--) {
            int[] e = edges[i];
            if(cycleNodes.contains(e[0]) && cycleNodes.contains(e[1])) return e;
        }
        return new int[]{};
    }

    public boolean hasCycle(Map<Integer, Set<Integer>> g, int node, int prevNode, boolean[] visited, Set<Integer> cycleNodes, int[] cycleStart) {

        if(visited[node]) {
            cycleStart[0] = node;
            return true;
        }
        
        visited[node] = true;
        
        for(int nextNode : g.get(node)) {
            if(nextNode == prevNode) continue;
            if(hasCycle(g, nextNode, node, visited, cycleNodes, cycleStart)) {
                if(cycleStart[0] != 0) {
                    cycleNodes.add(node);
                }
                if(cycleStart[0] == node) {
                    cycleStart[0] = 0;
                }
                return true;
            }
        }
        return false;
    }
}
