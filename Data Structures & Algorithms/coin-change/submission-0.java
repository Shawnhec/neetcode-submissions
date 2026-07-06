class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int res = dfs(coins, amount, memo);
        if(res == Integer.MAX_VALUE) return -1;
        return res;
    }

    public int dfs(int[] coins, int amount, int[] memo) {
        if(amount == 0) return 0; 

        if(amount < 0) return Integer.MAX_VALUE;

        if(memo[amount] != -1) return memo[amount];

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            int res = dfs(coins, amount - coins[i], memo);
            if(res != Integer.MAX_VALUE) {
                res += 1;
            }
            min = Math.min(min, res);
        }

        return memo[amount] = min;
    }
}
