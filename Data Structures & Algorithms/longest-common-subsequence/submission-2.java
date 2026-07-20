class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] memo = new int[m][n];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(text1, text2, memo, m - 1, n - 1);
    }


    public int dfs(String text1, String text2, int[][] memo, int i, int j) {
        if(i < 0 || j < 0) return 0;

        if(memo[i][j] != -1) return memo[i][j];

        if(text1.charAt(i) == text2.charAt(j)) {
            return memo[i][j] = dfs(text1, text2, memo, i - 1, j - 1) + 1;
        }

        return memo[i][j] = Math.max(dfs(text1, text2, memo, i, j - 1), dfs(text1, text2, memo, i - 1, j));
    }
}


/*
cat
ct

abcd 
dyxg

*/