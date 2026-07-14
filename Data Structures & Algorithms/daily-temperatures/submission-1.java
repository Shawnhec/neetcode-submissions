class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> memo = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!memo.isEmpty() && temperatures[i] > temperatures[memo.peek()]) {
                int idx = memo.pop();
                ans[idx] = i - idx;
            }

            memo.push(i);
        }
        return ans;
    }
}


/*
39, 38, 37, 40 39 38 

*/