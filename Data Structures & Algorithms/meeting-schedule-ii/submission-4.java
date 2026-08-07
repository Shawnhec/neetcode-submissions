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



// class Solution {
//     public int minMeetingRooms(List<Interval> intervals) {
//         int ans = 0;
//         int cnt = 0;
//         int n = intervals.size();
//         int[] starts = new int[n];
//         int[] ends = new int[n];

//         for(int i = 0; i < n; i++) {
//             starts[i] = intervals.get(i).start;
//             ends[i] = intervals.get(i).end;
//         }
        
//         Arrays.sort(starts);
//         Arrays.sort(ends);

//         int i = 0, j = 0;
//         while(i < n && j < n) {
//             if(starts[i] < ends[j]) {
//                 i++;
//                 cnt++;
//             }
//             else if(starts[i] >= ends[j]) {
//                 cnt--;
//                 j++;
//             }
//             ans = Math.max(ans, cnt);
//         }

//         while(j < n) {
//             j++;
//             cnt--;
//             ans = Math.max(ans, cnt);
//         }
//         return ans;
//     }
// }


class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int ans = 0;
        int cnt = 0;
        List<int[]> time = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            time.add(new int[]{intervals.get(i).start, 1});
            time.add(new int[]{intervals.get(i).end, -1});
        }

        Collections.sort(time, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        for(int[] t : time) {
            cnt += t[1];
            ans = Math.max(ans, cnt);
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