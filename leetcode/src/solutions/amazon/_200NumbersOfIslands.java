package solutions.amazon;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 * NO.200 Numbers of Islands
 * Keywords: Island
 * Difficulty: Medium
 * Company: Amazon
 */
public class _200NumbersOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        _200NumbersOfIslands s = new _200NumbersOfIslands();
        int i = s.numIslands(grid);
        System.out.println("total island = "+ i);
    }

    /**
     * solution 1: traditional dfs algorithm
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        List<List<Pair>> res = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    List<Pair> conn = new ArrayList<>();
                    dfs(grid,i,j,visited,conn);
                    if(conn.size() > 0){
                        conn.stream().map(p -> p.getKey() + ":"+p.getValue()+"->").collect(Collectors.toList()).forEach(System.out::print);
                        System.out.println();
                        res.add(conn);
                    }
                }
            }
        }
        return res.size();
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited, List<Pair> res){
        if(outOfArea(grid,i,j)){
            return;
        }
        if(grid[i][j] == '0'){
            return;
        }
        if(visited[i][j]){
            return;
        }
        visited[i][j] = true;
        res.add(new Pair(i,j));
        dfs(grid,i-1,j,visited,res);
        dfs(grid,i+1,j,visited,res);
        dfs(grid,i,j-1,visited,res);
        dfs(grid,i,j+1,visited,res);
    }

    private boolean outOfArea(char[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n){
            return true;
        }
        return false;
    }

    /**
     * solution 2: flood fill algorithm, a variant of dfs
     * When meet a point of an island, accumulate the total islands, and then flood the point and its entire island.
     * Flooding the entire island is a replacement of recording visited points
     * @param grid area
     * @return
     */
    public int numIslands2(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    res++;
                    floodFill(grid,i,j);
                }
            }
        }
        return res;
    }

    private void floodFill(char[][] grid, int i, int j){
        if(outOfArea(grid,i,j)){
            return;
        }
        if(grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';//flood this point
        //flood the entire island around this point
        floodFill(grid,i-1, j);
        floodFill(grid,i+1, j);
        floodFill(grid, i,j-1);
        floodFill(grid, i,j+1);
    }

}
