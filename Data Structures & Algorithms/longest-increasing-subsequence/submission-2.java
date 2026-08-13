
class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            List<Integer> lis = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int idx = lowerBound(lis, nums[i]);
                if (idx == lis.size()) lis.add(nums[i]);
                else lis.set(idx, nums[i]);
            }
            return lis.size();
        }

        public int lowerBound(List<Integer> lst, int target) {
            int left = 0, right = lst.size() - 1; 
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (lst.get(mid) >= target) {
                    right = mid - 1;
                }
                else left = mid + 1;
            }
            return left; 
        }
}