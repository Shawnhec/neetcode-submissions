class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(left <= right) {
                if(target <= nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
        }
        if(left >= nums.length || nums[left] != target) return -1;
        return left;
    }
}
