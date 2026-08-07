/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

// class Solution {
//     public int minMeetingRooms(List<Interval> intervals) {
//         Collections.sort(intervals, (a, b) -> a.start - b.start);
//         Queue<Integer> pq = new PriorityQueue<>();
//         for(Interval interval : intervals) {
//             if(!pq.isEmpty() && interval.start >= pq.peek()) {
//                 pq.poll();
//             }
//             pq.offer(interval.end);
//         }
//         return pq.size();
//     }
// }



class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int ans = 0;
        int cnt = 0;
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];

        for(int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);

        int i = 0, j = 0;
        while(i < n && j < n) {
            ans = Math.max(ans, cnt);
            if(starts[i] < ends[j]) {
                i++;
                cnt++;
                continue;
            }
            else if(starts[i] >= ends[j]) {
                cnt--;
                j++;
                continue;
            }
        }

        while(j < n) {
            ans = Math.max(ans, cnt);
            j++;
            cnt--;
        }
        return ans;
    }
}




/*
         |--|
            |----|
    |----|
|--------------------|              
0   5   10  15  20  40


*/