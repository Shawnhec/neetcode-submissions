// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         Map<Integer, Set<Integer>> g = new HashMap<>();
//         int[] traversalState = new int[numCourses];

//         for(int i = 0; i < numCourses; i++) {
//             g.put(i, new HashSet<>());
//         }
//         for(int[] p : prerequisites) {
//             g.get(p[1]).add(p[0]);
//         }
//         for(int i = 0; i < numCourses; i++) {
//             if(traversalState[i] == 1) continue;
//             if(hasCycle(g, i, traversalState)) return false; 
//         }
//         return true;
        
//     }


//     public boolean hasCycle(Map<Integer, Set<Integer>> g, int node, int[] traversalState) {
//         if(g.get(node).isEmpty()) {
//             traversalState[node] = 1;
//             return false;
//         }
//         if(traversalState[node] == 2) return true;

//         traversalState[node] = 2;
//         for(int nextNode : g.get(node)) {
//             if(traversalState[nextNode] == 1) continue;
//             if(hasCycle(g, nextNode, traversalState)) return true;
//         }
//         traversalState[node] = 1;
//         return false;
//     }
// }




class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> g = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            g.put(i, new HashSet<>());
        }
        for(int[] p : prerequisites) {
            g.get(p[1]).add(p[0]);
            indegrees[p[0]]++;
        }
        
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) que.offer(i);
        }

        int cnt = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            int node = que.poll();
            cnt++;
            for(int nextNode : g.get(node)) {
                indegrees[nextNode]--;
                if(indegrees[nextNode] == 0) que.offer(nextNode);
            }
        }

        return cnt == numCourses;
    }
}

