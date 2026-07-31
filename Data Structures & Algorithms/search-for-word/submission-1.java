class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[] w = word.toCharArray();
        boolean[] ans = new boolean[]{false};
        int[][] dirs = new int[][] {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] != w[0]) continue;
                else {
                    backTrack(board, w, i, j, 0, ans, dirs);
                }
                if(ans[0]) return true;
            }
        }
        return false;
    }

    public void backTrack(char[][] board, char[] word, int row, int col, int idx, boolean[] ans, int[][] dirs) {
        if(idx == word.length) {
            ans[0] = true;
            return;
        }
        
        int m = board.length, n = board[0].length;
        if(row < 0 || col < 0 || row >= m || col >= n || board[row][col] != word[idx] || board[row][col] == '@') return;
        
        char c = board[row][col];
        board[row][col] = '@';
        for(int[] dir : dirs) {
            backTrack(board, word, row + dir[0], col + dir[1], idx + 1, ans, dirs);
        }
        board[row][col] = c;
    }
}
