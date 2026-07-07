class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Integer, Set<int[]>> g = new HashMap<>();
        for(int i = 0; i < n; i++) {
            g.put(i, new HashSet<>());
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                g.get(i).add(new int[] {j, distance(points[i], points[j])});
                g.get(j).add(new int[] {i, distance(points[j], points[i])});
            }
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Set<Integer> visited = new HashSet<>();
        int ans = 0; 
        pq.offer(new int[]{0, 0});
        
        while(n > 0) {
            int[] leaving = pq.poll();
            if(visited.contains(leaving[0])) continue;
            visited.add(leaving[0]);
            ans += leaving[1];
            for(int[] neighbor : g.get(leaving[0])) {
                pq.offer(neighbor);
            }
            n--;
        }
        return ans;
    }

    public int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}



/*
[0,1,2,3]

[0,1]
[0,2]
[0,3]

[1,2]
[1,3]

[2,3]


*/