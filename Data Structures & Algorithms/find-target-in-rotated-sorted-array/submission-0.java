class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2; 
            if(nums[mid] == target) return mid;
            
            if(nums[left] <= nums[mid]) {
                if (target > nums[mid] || target < nums[left]){
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }

            else if (nums[left] > nums[mid]) {
                if(target >= nums[left] || target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}




/*
[6,7,0,1,2,4]
 l 
           r 
     m

[7,0,1,2,4,6]
 l 
           r 
     m



*/