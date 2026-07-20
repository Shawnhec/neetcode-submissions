class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(nums, memo, n - 1);
    }

    public int dfs(int[] nums, int[] memo, int i) {
        if(i < 0) return 0;

        if(memo[i] != -1) return memo[i];
        
        return memo[i] = Math.max(dfs(nums, memo, i - 1), dfs(nums, memo, i - 2) + nums[i]);
    }
}


/*
nums= [5,1,2,10, 6, 2, 7, 9,3, 1]
f:    [5,1,7,11,13,13,20,22,23,23]

*/