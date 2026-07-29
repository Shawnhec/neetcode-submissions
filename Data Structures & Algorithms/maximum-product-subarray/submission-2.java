class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length; 
        int ans = nums[0];
        int globalMax = 1;
        int globalMin = 1;
        for(int i = 0; i < n; i++) {
           int tmp = globalMax * nums[i];
           globalMax = Math.max(nums[i], Math.max(globalMax * nums[i], globalMin * nums[i]));
           globalMin = Math.min(nums[i], Math.min(globalMin * nums[i], tmp));
           ans = Math.max(ans, globalMax);
        }
        return ans;
    }
}


/*
nums = [2,4,-3,-5]

ans = 120

[2,8,-24, 120]




[-3, -2, -3, -5]
*/