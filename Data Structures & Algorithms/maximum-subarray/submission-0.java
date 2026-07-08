class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax = Integer.MIN_VALUE / 2;
        int localMax = Integer.MIN_VALUE / 2;
        for(int i = 0; i < nums.length; i++) {
            localMax = Math.max(nums[i], nums[i] + localMax);
            globalMax = Math.max(localMax, globalMax);
        }
        return globalMax;
    }
}
