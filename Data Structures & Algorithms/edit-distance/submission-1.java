class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] memo = new int[m][n];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(word1.toCharArray(), word2.toCharArray(), memo, m - 1, n - 1);
    }

    public int dfs(char[] word1, char[] word2, int[][] memo, int i, int j) {
        if(i < 0 && j < 0) return 0;
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(memo[i][j] != -1) return memo[i][j];

        if(word1[i] == word2[j]) {
            return memo[i][j] = dfs(word1, word2, memo, i - 1, j - 1);
        }

        int insertCnt = dfs(word1, word2, memo, i, j - 1);
        int deleteCnt = dfs(word1, word2, memo, i - 1, j);
        int replaceCnt = dfs(word1, word2, memo, i - 1, j - 1);

        return memo[i][j] = Math.min(insertCnt, Math.min(deleteCnt, replaceCnt)) + 1;
    }
}


/*
a1
m

dfs(1, 0)
    dfs(1, -1)
    return 2

    dfs(0, 0)
        dfs(0, -1)
        reutrn 1

        dfs(-1, 0)
        return 1

        dfs(-1, -1)
        return 0 
    return 1

    dsf(0, -1)
    return 1
reutrn 2






horse.   n = 5
ros      m.= 3


dfs(4,2)

    dfs(4, 1)
        dfs(4, 0)

            dfs(4 -1)
            return 0

            dfs(3, 0)
                dfs(3, -1)
                return 0

                dfs(2, 0)     
                    dfs(1, -1)
                    return 0
                return 0 

                dfs(2, -1)
                return 0
            return 1

            dfs(3, -1)
            return 0
        


        dfs(3, 1)

        dfs(3, 0)


    dfs(3, 2)

    dfs(3, 1)


*/