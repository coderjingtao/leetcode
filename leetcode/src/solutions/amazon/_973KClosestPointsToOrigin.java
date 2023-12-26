package solutions.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973 K Closest Points to Origin
 * Keywords:
 * Difficulty: Medium
 * Company: Amazon
 */
public class _973KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(point -> Math.pow(point[0],2) + Math.pow(point[1], 2)));
        for(int[] point : points){
            queue.offer(point);
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        _973KClosestPointsToOrigin s = new _973KClosestPointsToOrigin();
        int[][] points = {
                {3,3},
                {5,-1},
                {-2,4}
        };
        int[][] res = s.kClosest(points, 2);
        for(int[] point : res){
            System.out.println(Arrays.toString(point));
        }
    }

}
