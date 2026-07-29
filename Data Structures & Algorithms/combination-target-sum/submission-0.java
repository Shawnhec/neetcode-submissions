class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, ans, new ArrayList<>(), target, 0);
        return ans;
    }

    public void dfs(int[] nums, List<List<Integer>> ans, List<Integer> lst, int remain, int strt) {
        if(remain < 0) return;

        if(remain == 0) {
            ans.add(new ArrayList<>(lst));
            return;
        }

        for(int i = strt; i < nums.length; i++) {
            lst.add(nums[i]);
            dfs(nums, ans, lst, remain - nums[i], i);
            lst.removeLast();
        }
    }
}
