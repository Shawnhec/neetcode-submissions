class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++) {
            backTrack(nums, i, 0, new ArrayList<>(), ans);
        }
        return ans;
    }

    public void backTrack(int[] nums, int cnt, int strt, List<Integer> lst, List<List<Integer>> ans) {
        if(lst.size() == cnt) {
            ans.add(new ArrayList<>(lst));
            return;
        }
        
        for(int j = strt; j < nums.length; j++) {
            lst.add(nums[j]);
            backTrack(nums, cnt, j + 1, lst, ans);
            lst.removeLast();
        }
    }
}
