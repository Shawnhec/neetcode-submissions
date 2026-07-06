// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][] memo = new int[n + 1];
        
//     }

//     public int dfs(int[] prices, int i, int[][] memo, int hold, int reamin) {
//         if() {

//         }

//         int buy = dfs(prices, i - 1, memo, 0) - prices[i];
//         int hold = dfs(prices, i - 1, memo, 1);
//         int sell = dfs(prices, i - 1, memo, 1) + prices[i];

//         return memo[i] = Math.max(buy, Math.max(hold, sell));
//     }
// }


/*
prices = [10,1,5,6,7,1]


1. min = 10 
2. profit = 1 - 10 = -9 -> min = 1 
3. profit = 5 - 1 = 4 -> min = 1
4. profit = 6 - 1 = 
*/


class Solution {
    public int maxProfit(int[] prices) {
        int ans = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }
}