class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i = 0; 
        int n = intervals.length;
        int lb = newInterval[0];
        int ub = newInterval[1];
        
        while(i < n && lb > intervals[i][1]) {
            ans.add(intervals[i]);
            i++;
        }

        while(i < n && ub >= intervals[i][0]) {
            lb = Math.min(lb, intervals[i][0]);
            ub = Math.max(ub, intervals[i][1]);
            i++;
        }
        ans.add(new int[]{lb, ub});

        while(i < n) {
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}


/*
[1,8], [11,12]

a: [2,5]
b: [9,10]

[1,3],[4,5],[6,7],[8,10], [11,12]
[4,8]

[5,6]

*/