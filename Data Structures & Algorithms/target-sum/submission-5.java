class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length; 
        int total = 0;
        for(int i = 0; i < n; i++) total += nums[i];
        if(target > total) return 0;

        int[][] memo = new int[n][2 * total + 1];
        for(int[] row : memo) Arrays.fill(row, -1);

        return dp(nums, 0, 0, total, target, memo);

        
    }

    public int dp(int[] nums, int i, int cap, int total, int target, int[][] memo) {
        if(i == nums.length) {
            return cap == target ? 1 : 0;
        }

        if(memo[i][cap + total] != -1) return memo[i][cap + total];

        return memo[i][cap + total] = dp(nums, i + 1, cap + nums[i], total, target, memo) + dp(nums, i + 1, cap - nums[i], total, target, memo);
    }
}

/*
dp(0, 0, 6, 4)

    dp(1, 2, 6, 4)
        
        dp(2, 4, 6, 4)
            dp(3, 6, 6, 4)
            return 0 

            dp(3, 2, 6, 4)
            return 0 
        return 0

        dp(2, 0, 6, 4)
            dp(3, 2, 6, 4)
            return 0 

            dp(3, -2, 6, 4)
            return 0
        return 0 
    return 0 



    dp(1,-2, 6, 4)

*/
