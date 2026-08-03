class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Map<Integer, Set<Integer>> g = new HashMap<>();

        for(int i = 0; i < n; i++) {
            g.put(i, new HashSet<>());
        }
        for(int i = 0; i < edges.length; i++) {
            g.get(edges[i][0]).add(edges[i][1]);
            g.get(edges[i][1]).add(edges[i][0]);
        }

        if (hasCycle(0, -1, g, visited)) return false;
        
        int visitedSize = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i] == true) visitedSize++;
        }
        return visitedSize == n;
    }


    /*
    n=5
    edges=[[0,1],[0,2],[0,3],[1,4]]

    dfs(1)

    
    ========================
    dfs(0)
        dfs(1)
            dfs(0)
            continue

            dfs(4)
                dfs(1)
                continue
            return false
        return false

        dfs(2)
            dfs(0)
            continue
        return false
        
        dfs(3)
            dfs(0)
            continue
        return false
    return false

    
    visited:  t t     t
              0 1 2 3 4 
    g: {0: {1,2,3}
        1: {0,4}
        2: {0}
        3: {0}
        4: {1}}

    
    */

    public boolean hasCycle(int node, int parent, Map<Integer, Set<Integer>> g, boolean[] visited) {
        if(visited[node]) return true;;
        visited[node] = true;

        for(int nextNode : g.get(node)) {
            if(nextNode == parent) continue;
            if(hasCycle(nextNode, node, g, visited)) return true;
        }
        return false;
    }
}
