// class Solution {
//     public int minDistance(String word1, String word2) {
//         int m = word1.length(), n = word2.length();
//         int[][] memo = new int[m][n];
//         for(int[] row : memo) {
//             Arrays.fill(row, -1);
//         }
//         return dfs(word1.toCharArray(), word2.toCharArray(), memo, m - 1, n - 1);
//     }

//     public int dfs(char[] word1, char[] word2, int[][] memo, int i, int j) {
//         if(i < 0 && j < 0) return 0;
//         if(i < 0) return j + 1;
//         if(j < 0) return i + 1;

//         if(memo[i][j] != -1) return memo[i][j];

//         if(word1[i] == word2[j]) {
//             return memo[i][j] = dfs(word1, word2, memo, i - 1, j - 1);
//         }

//         int insertCnt = dfs(word1, word2, memo, i, j - 1);
//         int deleteCnt = dfs(word1, word2, memo, i - 1, j);
//         int replaceCnt = dfs(word1, word2, memo, i - 1, j - 1);

//         return memo[i][j] = Math.min(insertCnt, Math.min(deleteCnt, replaceCnt)) + 1;
//     }
// }



class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] f = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 && j == 0) f[i][j] = 0;
                else if (i == 0) {
                    f[i][j] = j;
                } 
                else if (j == 0) {
                    f[i][j] = i;
                }
            }
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                }
                else {
                    int insertCnt = f[i][j - 1];
                    int deleteCnt = f[i - 1][j];
                    int replaceCnt = f[i - 1][j - 1];
                    f[i][j] = Math.min(insertCnt, Math.min(deleteCnt, replaceCnt)) + 1;
                }

            }
        }
        return f[m][n];
    }
}



