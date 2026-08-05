class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        
        Map<Integer, Set<Integer>> g = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for(int i = 0; i < numCourses; i++) g.put(i, new HashSet<>());
        
        for(int[] p : prerequisites) {
            g.get(p[1]).add(p[0]);
            indegrees[p[0]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) que.offer(i);
        }
        
        int i = 0;
        int finish = 0;
        while(!que.isEmpty()) {
            int node = que.poll();
            ans[i] = node;
            i++;
            finish++;
            for(int nextNode : g.get(node)) {
                indegrees[nextNode]--;
                if(indegrees[nextNode] == 0) que.offer(nextNode);
            }
        }
        
        if(finish != numCourses) return new int[]{};

        return ans;
    }
}
