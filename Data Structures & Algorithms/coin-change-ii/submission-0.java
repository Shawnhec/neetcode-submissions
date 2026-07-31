class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length; 
        int[][] memo = new int[amount + 1][n];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(amount, coins, n - 1, memo);
    }

    private int dp(int amount, int[] coins, int i, int[][] memo) {
        if(amount == 0) return 1;
        if(amount < 0) return 0;

        if(i < 0 && amount > 0) return 0;

        if(memo[amount][i] != -1) return memo[amount][i];
        
        return memo[amount][i] = dp(amount - coins[i], coins, i, memo) + dp(amount, coins, i - 1, memo);

    }
}


/*
amount = 4
[1, 2, 3]


dp(4, 0)
    dp(3, 0)
        dp(2, 0)
            dp(1, 0)
                dp(0, 0)
                return 1

                dp(-1, 1)
                return 0

                dp(-2, 2)
                return 0
            return 1
            
            dp(0, 1)
            return 1

            dp(-1, 2)
            return 0
        return 2

        dp(1, 1)
        return 1

        dp(0, 2)
        return 1
    return 4

    dp(2, 1)

    dp(1, 2)
    
    
        
        
    
    




*/