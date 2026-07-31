class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        int ans = -1;
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    que.offer(new int[]{i, j});
                }
            }
        }
        

        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                int[] curr = que.poll();
                grid[curr[0]][curr[1]] = 2;
                for(int[] dir : dirs) {
                    int nxtRow = curr[0] + dir[0];
                    int nxtCol = curr[1] + dir[1];
                    if(nxtRow >= 0 && nxtCol >= 0 && nxtRow < m && nxtCol < n && grid[nxtRow][nxtCol] == 1) {
                        grid[nxtRow][nxtCol] = 2;
                        que.offer(new int[]{nxtRow, nxtCol});
                    }
                }
            }
            ans++;
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }

        return Math.max(ans, 0);
    }
}
