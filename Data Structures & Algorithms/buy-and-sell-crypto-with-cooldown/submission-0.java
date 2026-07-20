class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] memo = new int[n][2];
        for(int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return dfs(prices, memo, n - 1, 0);
    }

    public int dfs(int[] prices, int[][] memo, int i, int hold) {
        if(i < 0 && hold == 1) return Integer.MIN_VALUE;
        else if(i < 0 && hold == 0) return 0;

        if(memo[i][hold] != Integer.MIN_VALUE) return memo[i][hold];

        int res = 0;
        if(hold == 0) {
            // carried nothing from yesterday vs. sell
            res = Math.max(dfs(prices, memo, i - 1, 0), dfs(prices, memo, i - 1, 1) + prices[i]);
        }

        else if (hold == 1) {
            // carried over from previous day vs. buy
            res = Math.max(dfs(prices, memo, i - 1, 1),  dfs(prices, memo, i - 2, 0) - prices[i]);
        }
        return memo[i][hold] = res;
    }
}


/*
dfs(4, 0)

    dfs(3, 0)
        
        dfs(2, 0)

            dfs(1, 0)

                dfs(0, 0)

                    dfs(-1, 0)
                    return 0

                    dfs(-1, 1) + 1
                    return -inf
                return 0

                dfs(0, 1) + 3

                    dfs(-1, 1)
                    return -inf

                    dfs(-1, 0) - 1
                    return 0 - 1
                return -1 + 3 = 2 
            return 2

    dfs(3, 1) + 4 

    

*/
