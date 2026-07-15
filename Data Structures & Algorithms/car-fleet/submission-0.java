class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for(int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a, b) -> b[0] - a[0]);
        Stack<Double> stk = new Stack<>();
        for(int[] p : pair) {
            // stk.push((double) target - p[0] / p[1]);
            double curr = (double) (target - p[0]) / p[1];
            if(stk.isEmpty() || !stk.isEmpty() && curr > stk.peek()) {
                stk.push(curr);
            }
        }

        return stk.size();
    }
}
