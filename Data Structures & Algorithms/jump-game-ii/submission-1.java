class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int currEnd = 0;
        int nextEnd = 0;
        for(int i = 0; i < n - 1; i++) {
            nextEnd = Math.max(nextEnd, i + nums[i]);
            if(currEnd == i) {
                ans++;
                currEnd = nextEnd;
            }
        }
        return ans;
    }
}
