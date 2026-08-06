class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        int[][] dirs = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    dfs(board, i, j, dirs);
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '0') board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int row, int col, int[][] dirs) {
        int m = board.length, n = board[0].length;
        if(row < 0 || col < 0 || row >= m || col >= n || board[row][col] == 'X' || board[row][col] == '0') return;

        board[row][col] = '0';
        for(int[] dir : dirs) dfs(board, row + dir[0], col + dir[1], dirs);
    }

    
}
