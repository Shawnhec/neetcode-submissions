class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length; 
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, dp(nums, i, memo));
        }
        return ans;
    }

    public int dp(int[] nums, int i, int[] memo) {
        if(memo[i] != -1) return memo[i];

        int res = 1;
        for(int j = 0; j < i; j++) {
            if(nums[j] < nums[i]) {
                res = Math.max(res, dp(nums, j, memo) + 1);
            }
        }
        return memo[i] = res; 
    }
}
