class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) sum += nums[i];
        if (Math.abs(target) > sum) {
            return 0;
        }
        int max = sum;

        Map<Integer, Map<Integer, Integer>> sols = new HashMap<>();
        for(int i = 0; i <= n; i++) {
            sols.put(i, new HashMap<>());
            for(int j = -max; j <= max; j++) {
                sols.get(i).put(j, 0);
            }
        }

        sols.get(0).put(0, 1);
        
        for(int i = 1; i <= n; i++) {
            for(int j = -max; j <= max; j++) {
                int prevSol = sols.get(i - 1).get(j);
                if(prevSol == 0) continue;
                
                int currNum = nums[i - 1];
                int plus = j + currNum;
                int minus = j - currNum;

                sols.get(i).put(plus, sols.get(i).getOrDefault(plus, 0) + prevSol);
                sols.get(i).put(minus, sols.get(i).getOrDefault(minus, 0) + prevSol);
            }
        }

        return sols.get(n).get(target);
    }
}
