class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sumOfDiff = 0;
        for(int i = 0; i < n; i++) {
            sumOfDiff += (gas[i] - cost[i]);
        }
        if(sumOfDiff < 0) return -1;
        
        int total = 0;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            if(total < 0) {
                total = 0;
                ans = i + 1;
            }
        }
        return ans;
    }
}
