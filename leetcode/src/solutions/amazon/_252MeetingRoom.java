package solutions.amazon;

import java.util.Arrays;
import java.util.Comparator;

/**
 * NO.252 Meeting Room
 * Keywords: Interval
 * Difficulty: Easy
 * Company: Google, Amazon, eBay
 */
public class _252MeetingRoom {

    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0){
            return true;
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int earliestEndTime = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < earliestEndTime){
                return false;
            }
            earliestEndTime = intervals[i][1];
        }
        return true;
    }
}
