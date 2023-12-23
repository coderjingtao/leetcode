package solutions.amazon;

/**
 * NO.1254 Numbers of Closed Islands
 * Keywords: Island
 * Difficulty: Medium
 * Company: Google, Amazon, Microsoft, Adobe
 */
public class _1254NumbersOfClosedIslands {

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,1,1,1,1,1},
                {1,0,0,0,0,0,1},
                {1,0,1,1,1,0,1},
                {1,0,1,0,1,0,1},
                {1,0,1,1,1,0,1},
                {1,0,0,0,0,0,1},
                {1,1,1,1,1,1,1},
        };
        _1254NumbersOfClosedIslands s = new _1254NumbersOfClosedIslands();
        int num = s.closedIsland(grid);
        System.out.println("num = " + num);
    }

    public int closedIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    res++;
                    boolean[] reachEdge = new boolean[1];
                    floodFill(grid,i,j,reachEdge);
                    if(reachEdge[0]){
                        res--;
                    }
                }
            }
        }
        return res;
    }

    private void floodFill(int[][] grid, int i, int j, boolean[] reachEdge){
        if(outOfArea(grid,i,j)){
            return;
        }
        if(grid[i][j] == 1){//water
            return;
        }
        if(reachEdge(grid, i, j)){
            reachEdge[0] = true;
        }
        grid[i][j] = 1;//set to water
        floodFill(grid,i-1, j, reachEdge);
        floodFill(grid,i+1, j, reachEdge);
        floodFill(grid, i, j-1, reachEdge);
        floodFill(grid, i, j+1,reachEdge);
    }

    private boolean outOfArea(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n){
            return true;
        }
        return false;
    }
    private boolean reachEdge(int[][] grid, int i, int j){
        int m = grid.length-1, n = grid[0].length-1;
        if(i == 0 || j == 0 || i == m || j == n){
            return true;
        }
        return false;
    }
}
