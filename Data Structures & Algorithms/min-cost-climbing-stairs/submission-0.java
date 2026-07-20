class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] stairMinCosts = new int[n + 1];
        // stairMinCosts[1] = cost[0];
        stairMinCosts[2] = Math.min(cost[0], cost[1]);
        for(int i = 3; i <= n; i++) {
            stairMinCosts[i] = Math.min(stairMinCosts[i - 1] + cost[i - 1], stairMinCosts[i - 2] + cost[i - 2]);
        }
        return stairMinCosts[n];  
    }
}



/*


 -
-
*/