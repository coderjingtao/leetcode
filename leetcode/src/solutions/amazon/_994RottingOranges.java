package solutions.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994 Rotting Oranges
 * Keywords: BFS
 * Difficulty: Medium
 * Company: Amazon, TikTok
 */
public class _994RottingOranges {

    private int[][] dirs = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1},
    };

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int fresh_count = 0, minutes = 0;
        Queue<int[]> rottenQueue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    fresh_count++;
                }
                if(grid[i][j] == 2){
                    rottenQueue.offer(new int[]{i,j});
                }
            }
        }
        while(!rottenQueue.isEmpty() && fresh_count > 0){
            int rotten_size = rottenQueue.size();
            for(int i = 0; i < rotten_size; i++){
                int[] rotten = rottenQueue.poll();
                for(int[] dir : dirs){
                    int next_i = rotten[0] + dir[0];
                    int next_j = rotten[1] + dir[1];
                    //if the adjacent cell inside the boundary and is fresh, then make it rotten and add it to queue and reduce the fresh count
                    if(next_i >= 0 && next_j >= 0 && next_i < m && next_j < n && grid[next_i][next_j] == 1){
                        grid[next_i][next_j] = 2;
                        rottenQueue.offer(new int[]{next_i,next_j});
                        fresh_count--;
                    }
                }
            }
            minutes++;
        }
        return fresh_count == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        _994RottingOranges s = new _994RottingOranges();

        //int[][] grid = {
        //        {2,1,1},
        //        {1,1,0},
        //        {0,1,1}
        //};
        //int[][] grid = {
        //        {2,1,1},
        //        {0,1,1},
        //        {1,0,1}
        //};
        //int[][] grid = {
        //        {0,2},
        //};
        int[][] grid = {
                {2,1,1},
                {1,1,1},
                {0,1,2}
        };
        int res = s.orangesRotting(grid);
        System.out.println(res);
    }
}
