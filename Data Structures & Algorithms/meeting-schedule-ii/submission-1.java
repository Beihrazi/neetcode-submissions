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
        int i=0, j=0,n = intervals.size();
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        while(i<n){
            start[i] = intervals.get(i).start;
            end[j] = intervals.get(i).end;
            i++;
            j++;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        i=0;
        j=0;
        int room =0, maxRoom=0;
        while(i<n){
            if(start[i] < end[j]){
                room++;
                maxRoom = Math.max(room, maxRoom);
                i++;
            }else{
                room--;
                j++;
            }
        }
        return maxRoom;

    }
}
