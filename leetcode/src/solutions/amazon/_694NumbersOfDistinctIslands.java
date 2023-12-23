package solutions.amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * NO.694 Numbers of Distinct Islands
 * Keywords: Island
 * Difficulty: Medium
 * Company: Amazon, TikTok, Microsoft
 */
public class _694NumbersOfDistinctIslands {
    public static void main(String[] args) {
        int[][] grid = {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1},
        };
        _694NumbersOfDistinctIslands s = new _694NumbersOfDistinctIslands();
        int num = s.numDistinctIslands(grid);
        System.out.println("num = " + num);
    }
    public int numDistinctIslands(int[][] grid) {
        Set<String> res = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    StringBuilder path = new StringBuilder();
                    dfs(grid,i,j,path,0);//don't care the initial direction
                    System.out.println(path.toString());
                    res.add(path.toString());
                }
            }
        }
        return res.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder path, int direction){
        if(outOfArea(grid, i, j)){
            return;
        }
        if(grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        path.append(direction);
        dfs(grid, i-1, j, path, 1);//up
        dfs(grid, i+1, j, path, 2);//down
        dfs(grid, i, j-1, path, 3);//left
        dfs(grid, i, j+1, path, 4);//right
        path.append(-direction);
    }

    private boolean outOfArea(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n){
            return true;
        }
        return false;
    }
}
