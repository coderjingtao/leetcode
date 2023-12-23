package solutions.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * NO.695 Max Area of Island
 * Keywords: Island
 * Difficulty: Medium
 * Company: Facebook, Dropbox, Amazon, Google, Microsoft
 */
public class _695MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0},
        };
        _695MaxAreaOfIsland s = new _695MaxAreaOfIsland();
        int max = s.maxAreaOfIsland(grid);
        System.out.println("max = " + max);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    List<Integer> res = new ArrayList<>();
                    dfs(grid,i,j,visited,res);
                    max = Math.max(max, res.size());
                }
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited, List<Integer> res){
        if(outOfArea(grid,i,j)){
            return;
        }
        if(grid[i][j] == 0){
            return;
        }
        if(visited[i][j]){
            return;
        }
        visited[i][j] = true;
        res.add(1);
        dfs(grid,i-1,j,visited,res);
        dfs(grid,i+1,j,visited,res);
        dfs(grid,i,j-1,visited,res);
        dfs(grid,i,j+1,visited,res);
    }
    private boolean outOfArea(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j>= n){
            return true;
        }
        return false;
    }
}
