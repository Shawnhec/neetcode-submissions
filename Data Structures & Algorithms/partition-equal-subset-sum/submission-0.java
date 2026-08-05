class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 == 1) return false;

        Boolean[][] memo = new Boolean[nums.length][sum / 2 + 1];
        
        return dp(nums, 0, sum / 2, memo); 
    }

    public boolean dp(int[] nums, int i, int target, Boolean[][] memo) {
        if(i == nums.length) {
            return target == 0; 
        }

        if(target < 0) return false;
        
        if(memo[i][target] != null) return memo[i][target];
        
        memo[i][target] = dp(nums, i + 1, target, memo)  || dp(nums, i + 1, target - nums[i], memo);
        return memo[i][target]; 
    }
}
