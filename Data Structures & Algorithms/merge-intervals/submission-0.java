class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        List<int[]> merged = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int[] curr = intervals[i];
            int min = curr[0];
            int max = curr[1];
            int j = i + 1;
            while(j < n && max >= intervals[j][0]) {
                min = Math.min(min, intervals[j][0]);
                max = Math.max(max, intervals[j][1]);
                j++;
            }
            merged.add(new int[]{min, max});
            i = j - 1;
        }

        int[][] ans = new int[merged.size()][2];
        for(int i = 0; i < merged.size(); i++) {
            ans[i] = merged.get(i);
        }
        return ans;
    }
}
