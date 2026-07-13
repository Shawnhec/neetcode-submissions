class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, new ArrayList<>(), ans, new HashSet<>());
        return ans;
    }

    public void dfs(int[] nums, List<Integer> lst, List<List<Integer>> ans, Set<Integer> visited) {
        if(lst.size() == nums.length) {
            ans.add(new ArrayList<>(lst));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(visited.contains(nums[i])) continue;

            lst.add(nums[i]);
            visited.add(nums[i]);
            dfs(nums, lst, ans, visited);
            visited.remove(nums[i]);
            lst.removeLast();
        }
    }
}
