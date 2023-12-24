package solutions.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56 Merge Intervals
 * Keywords: Interval
 * Difficulty: Medium
 * Company: Facebook, Bloomberg, Amazon, Google, Microsoft
 */
public class _56MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {
                {1,4},
                {0,2},
                {3,5},
        };
        _56MergeIntervals s = new _56MergeIntervals();
        int[][] res = s.merge(intervals);
        for(int[] interval : res){
            System.out.println(Arrays.toString(interval));
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> res = new ArrayList<>();

        int[] prev = intervals[0];
        res.add(prev);
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[0] <= prev[1]){
                res.remove(prev);
                prev = new int[]{prev[0],Math.max(prev[1],curr[1])};
            }else{
                prev = curr;
            }
            res.add(prev);
        }
        return res.toArray(new int[res.size()][]);
    }
}
