class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();

        int[][] dirs = new int[][] {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        boolean[][] pacVisited = new boolean[m][n];
        boolean[][] atlVisited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            dfs(heights, i, 0, dirs, pacVisited);
            dfs(heights, i, n - 1, dirs, atlVisited);
        }

        for(int j = 0; j < n; j++) {
            dfs(heights, 0, j, dirs, pacVisited);
            dfs(heights, m - 1, j, dirs, atlVisited);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacVisited[i][j] && atlVisited[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
        
    }

    public void dfs(int[][] heights, int row, int col, int[][] dirs, boolean[][] visited) {
        int m = heights.length, n = heights[0].length;
        if(row < 0 || col < 0 || row >= m || col >= n || visited[row][col]) return;
        
        visited[row][col] = true;
        for(int[] dir : dirs) {
            int nextRow = row + dir[0], nextCol = col + dir[1];
            if(nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n && heights[row][col] <= heights[nextRow][nextCol]) {
                dfs(heights, nextRow, nextCol, dirs, visited);
            }
        }
    }
}
