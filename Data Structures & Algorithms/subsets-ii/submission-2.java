class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void backTrack(int[] nums, int strt, List<Integer> subset,  List<List<Integer>> ans) {
        ans.add(new ArrayList<>(subset));

        for(int i = strt; i < nums.length; i++) {
            if(i > strt && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            backTrack(nums, i + 1, subset,  ans);
            subset.removeLast();
        }
    }
}


/*

num = [1,1,2]

*/