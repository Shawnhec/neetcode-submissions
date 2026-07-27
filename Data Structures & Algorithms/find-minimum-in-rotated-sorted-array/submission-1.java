class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1; 
        int end = nums[right];
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > end) {
                left = mid + 1;
            }
            else if (nums[mid] <= end) {
                right = mid - 1;
            }
        }
        return nums[left];
    }
}



/*

nums = [4, 5, 6, 7]
        l 
                 r 
           m
                



nums = [3,4,5,6,1,2]
              l
              r
              m



nums = [5, 6, 1 2, 3, 4 ]
        l 
           r 
     m 
*/