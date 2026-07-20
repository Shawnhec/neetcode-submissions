class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(m - 1, n - 1, memo);
    }

    public int dp(int i, int j, int[][] memo) {
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;

        if(memo[i][j] != - 1) return memo[i][j];
        
        return memo[i][j] = dp(i - 1, j, memo) + dp(i, j - 1, memo);
    }
}
