class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> g = new HashMap<>();
        // int[] traversalState = new int[numCourses];
        Set<Integer> visiting = new HashSet<>();

        for(int i = 0; i < numCourses; i++) {
            g.put(i, new HashSet<>());
        }
        for(int[] p : prerequisites) {
            g.get(p[1]).add(p[0]);
        }
        for(int i = 0; i < numCourses; i++) {
            if(hasCycle(g, i, visiting)) return false; 
        }
        return true;
        
    }


    public boolean hasCycle(Map<Integer, Set<Integer>> g, int node, Set<Integer> visiting) {
        if(g.get(node).isEmpty()) return false;
        if(visiting.contains(node)) return true;

        visiting.add(node);
        for(int nextNode : g.get(node)) {
            if(hasCycle(g, nextNode, visiting)) return true;
        }
        visiting.remove(node);
        return false;
    }
}
