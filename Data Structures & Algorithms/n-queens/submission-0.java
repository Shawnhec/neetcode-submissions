class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        backTrack(n, 0, cols, diag1, diag2, new ArrayList<>(), ans, new StringBuilder());
        return ans;
    }

    public void backTrack(int n, int row, boolean[] cols, boolean[] diag1, boolean[] diag2, List<String> board, List<List<String>> ans, StringBuilder sb) {
        if(row == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int col = 0; col < n; col++) {
            if(cols[col] || diag1[row + col] || diag2[row - col + n - 1]) continue;

            int offset = col;
            
            cols[col] = true;
            diag1[row + col] = true;
            diag2[row - col + n - 1] = true;
            for(int j = 0; j < offset; j++) {
                sb.append('.');
            }
            sb.append('Q');
            for(int j = offset + 1; j < n; j++) {
                sb.append('.');
            }
            board.add(sb.toString());
            sb.setLength(0);
            backTrack(n, row + 1, cols, diag1, diag2, board, ans, sb);
            board.removeLast();
            // sb.deleteCharAt(sb.length() - 1);
            diag2[row - col + n - 1] = false;
            diag1[row + col] = false;
            cols[col] = false;
        }
    }
}
