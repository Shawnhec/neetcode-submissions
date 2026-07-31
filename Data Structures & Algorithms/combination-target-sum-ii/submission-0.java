class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }

    public void backTrack(int[] candidates, int target, int i, List<List<Integer>> ans, List<Integer> combination) {
        if(target == 0) {
            ans.add(new ArrayList<>(combination));
            return;
        }
        if(target < 0) return; 
        
        for(int j = i; j < candidates.length; j++) {
            if(j > i && candidates[j] == candidates[j - 1]) continue;
            combination.add(candidates[j]);
            backTrack(candidates, target - candidates[j], j + 1, ans, combination);
            combination.removeLast();
        }
        
    }
}


/*
candidates=[9,2,2,4,6,1,5]
[1,2,2,4,5,6,9]
   

*/
