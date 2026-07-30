class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        int ans = 0;
        int preEnd = intervals[0][1];
        for(int i = 1; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start >= preEnd) {
                preEnd = end;
            }
            else if (start < preEnd) {
                preEnd = Math.min(preEnd, end);
                ans++;
            }
        }
        return ans;
    }
}


/*
intervals=[[1,100],[11,22],[1,11],[2,12]]

[1,100]



*/