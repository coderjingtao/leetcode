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
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        int[] earliestEndInterval = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(earliestEndInterval[1] > intervals[i][0]){
                return false;
            }
            earliestEndInterval = intervals[i];
        }
        return true;
    }
}
