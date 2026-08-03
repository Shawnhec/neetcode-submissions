class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> g = new HashMap<>();
        int[] traversalState = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            g.put(i, new HashSet<>());
        }
        for(int[] p : prerequisites) {
            g.get(p[1]).add(p[0]);
        }
        for(int i = 0; i < numCourses; i++) {
            if(traversalState[i] == 1) continue;
            if(hasCycle(g, i, traversalState)) return false; 
        }
        return true;
        
    }


    public boolean hasCycle(Map<Integer, Set<Integer>> g, int node, int[] traversalState) {
        if(g.get(node).isEmpty()) {
            // traversalState[node] = 1;
            return false;
        }
        if(traversalState[node] == 2) return true;

        traversalState[node] = 2;
        for(int nextNode : g.get(node)) {
            if(traversalState[nextNode] == 1) continue;
            if(hasCycle(g, nextNode, traversalState)) return true;
        }
        traversalState[node] = 1;
        return false;
    }
}
