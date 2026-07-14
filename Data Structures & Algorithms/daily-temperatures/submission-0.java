class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<int[]> memo = new Stack<>();
        // int[]{temp, index}
        for(int i = 0; i < n; i++) {
            while(!memo.isEmpty() && temperatures[i] > memo.peek()[0]) {
                int[] leaving = memo.pop();
                ans[leaving[1]] = i - leaving[1];
            }

            memo.push(new int[]{temperatures[i], i});
        }
        return ans;
    }
}


/*
39, 38, 37, 40 39 38 

*/