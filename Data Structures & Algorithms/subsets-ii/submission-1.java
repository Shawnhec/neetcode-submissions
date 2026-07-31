class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int size = 0; size <= nums.length; size++) {
            backTrack(nums, 0, new ArrayList<>(), size, ans);
        }
        return ans;
    }

    public void backTrack(int[] nums, int strt, List<Integer> subset, int size, List<List<Integer>> ans) {
        if(subset.size() == size) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        for(int i = strt; i < nums.length; i++) {
            if(i > strt && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            backTrack(nums, i + 1, subset, size, ans);
            subset.removeLast();
        }
    }
}


/*

num = [1,1,2]

*/