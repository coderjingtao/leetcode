package solutions.amazon;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452 Minimum number of Arrows to Burst Balloons
 * Keywords: Interval
 * Difficulty: Medium
 * Company: Amazon, Apple, Google, Facebook
 */
public class _452MinimumArrowsToBurstBalloons {

    public static void main(String[] args) {
        int[][] points = {
                {1,2},
                {2,3},
                {3,4},
                {4,5}
        };
        _452MinimumArrowsToBurstBalloons s = new _452MinimumArrowsToBurstBalloons();
        int minArrowShots = s.findMinArrowShots(points);
        System.out.println("minArrowShots = " + minArrowShots);
    }

    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));
        int minArrowNum = 1;
        int[] leftmost_balloon = points[0];
        for(int i = 1; i < points.length; i++){
            if(leftmost_balloon[1] < points[i][0]){
                minArrowNum++;
                leftmost_balloon = points[i];
            }
        }
        return minArrowNum;
    }
}
