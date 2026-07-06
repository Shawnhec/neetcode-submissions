class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while(left < n - 2) {
            if(left != 0 && nums[left - 1] == nums[left]) {
                left++; 
                continue;
            }
            int right = n - 1;
            int mid = left + 1;
            while(mid < right) {
                int threeSum = nums[left] + nums[mid] + nums[right];
                if(mid - 1 != left && nums[mid - 1] == nums[mid]) {
                    mid++;
                    continue;
                }
                if(threeSum == 0) {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[left]);
                    lst.add(nums[mid]);
                    lst.add(nums[right]);
                    ans.add(lst);
                }
                else if (threeSum < 0) {
                    mid++;
                    continue;
                }
                else if (threeSum > 0) {
                    right--;
                    continue;
                }
                mid++;
            }
            left++;
        }
        return ans;
    }
}



/*
nums = [-1,0,1,2,-1,-4, -4]

->.    [-4,-4,-1,-1,0,1,2]

*/