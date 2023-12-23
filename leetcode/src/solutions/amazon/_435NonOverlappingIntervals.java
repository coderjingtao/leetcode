package solutions.amazon;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435 Non-Overlapping intervals
 * Keywords: Interval
 * Difficulty: Medium
 * Company: Facebook, Google, Amazon
 */
public class _435NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        int max_non_overlap_num = 1;
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        int[] earliestEndInterval = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(earliestEndInterval[1] <= intervals[i][0]){
                max_non_overlap_num++;
                earliestEndInterval = intervals[i];
            }
        }
        return intervals.length - max_non_overlap_num;
    }
}
