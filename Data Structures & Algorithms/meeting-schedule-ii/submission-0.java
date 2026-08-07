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

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        Queue<Integer> pq = new PriorityQueue<>();
        for(Interval interval : intervals) {
            if(!pq.isEmpty() && interval.start >= pq.peek()) {
                pq.poll();
            }
            pq.offer(interval.end);
        }
        return pq.size();
    }
}






/*

            |----|
    |----|
|--------------------|              
0   5   10  15  20  40


*/