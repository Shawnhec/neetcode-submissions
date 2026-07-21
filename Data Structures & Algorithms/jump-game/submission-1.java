class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        for(int i = 0; i < n; i++) {
            if(i <= maxLen) {
                maxLen = Math.max(maxLen, i + nums[i]);
            }
        }
        return maxLen >= n - 1;
    }
}



/*
nums=[2,3,1,1,4]




n = 5
maxLen = 0

i = 0
maxLen = max(3, 3) = 3




*/