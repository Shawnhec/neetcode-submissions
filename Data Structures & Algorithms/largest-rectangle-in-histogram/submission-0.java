class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<int[]> stk = new Stack<>();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i]);

            if(stk.isEmpty()) {
                stk.push(new int[]{i, heights[i]});
            }
            
            else{
                if(heights[i] > stk.peek()[1]) {
                    stk.push(new int[]{i, heights[i]});
                    continue;
                }

                int maxExtend = i;
                while(!stk.isEmpty() && heights[i] <= stk.peek()[1]) {
                    int[] prev = stk.pop();
                    maxExtend = prev[0];
                    ans = Math.max(ans, prev[1] * (i - prev[0]));
                }
                stk.push(new int[]{maxExtend, heights[i]});
            }
        }

        while(!stk.isEmpty()) {
            int[] prev = stk.pop();
            ans = Math.max(ans, prev[1] * (n - prev[0]));
        }
        return ans;
    }
}



/*
   &
  &&
 &&&
*/