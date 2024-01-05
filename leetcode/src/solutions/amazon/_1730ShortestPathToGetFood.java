package solutions.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1730 Shortest Path to Get Food
 * Keywords: BFS
 * Difficulty: Medium
 * Company: Amazon, DoorDash, Google
 */
public class _1730ShortestPathToGetFood {

    int[][] dirs = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };
    public int getFood(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '*'){
                    queue.offer(new int[]{i,j});
                    break;
                }
            }
        }
        int step = 0;
        boolean findFood = false;
        while(!queue.isEmpty() && !findFood){
            int size = queue.size();
            while(size-- > 0 && !findFood){
                int[] cell = queue.poll();
                for (int[] dir : dirs) {
                    int next_i = cell[0] + dir[0];
                    int next_j = cell[1] + dir[1];
                    if(isFreeSpace(grid,next_i,next_j)){
                        grid[next_i][next_j] = '*';
                        queue.offer(new int[]{next_i,next_j});
                    }
                    if(isFood(grid,next_i,next_j)){
                        findFood = true;
                        break;
                    }
                }
            }
            step++;
        }
        return findFood ? step : -1;
    }

    private boolean inArea(char[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i >= 0 && i < m && j >= 0 && j < n ){
            return true;
        }
        return false;
    }
    private boolean isFreeSpace(char[][] grid, int i, int j){
        if(inArea(grid,i,j) && grid[i][j] == 'O'){
            return true;
        }
        return false;
    }
    private boolean isFood(char[][] grid, int i, int j){
        if(inArea(grid,i,j) && grid[i][j] == '#'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //char[][] grid = {
        //        {'X','X','X','X','X','X'},
        //        {'X','*','O','O','O','X'},
        //        {'X','O','O','#','O','X'},
        //        {'X','X','X','X','X','X'},
        //};
        //char[][] grid = {
        //        {'X','X','X','X','X'},
        //        {'X','*','X','O','X'},
        //        {'X','O','X','#','X'},
        //        {'X','X','X','X','X'},
        //};
        //char[][] grid = {
        //        {'X','X','X','X','X','X','X','X'},
        //        {'X','*','O','X','O','#','O','X'},
        //        {'X','O','O','X','O','O','X','X'},
        //        {'X','O','O','O','O','#','O','X'},
        //        {'X','X','X','X','X','X','X','X'},
        //};
        char[][] grid = {
                {'O','*'},
                {'#','O'}
        };
        _1730ShortestPathToGetFood s = new _1730ShortestPathToGetFood();
        int steps = s.getFood(grid);
        System.out.println("steps = " + steps);
    }
}
