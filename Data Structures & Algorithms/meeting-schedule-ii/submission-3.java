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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));

        for(Interval interval : intervals){
            if(!pq.isEmpty() && interval.start >= pq.peek()){
                pq.poll();
            }
            pq.add(interval.end);
        }
        return pq.size();
    }
}
