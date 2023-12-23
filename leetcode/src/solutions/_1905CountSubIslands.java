package solutions;

/**
 * NO.1905 Count Sub Islands
 * Keywords: Island
 * Difficulty: Medium
 * Company: Twitter
 */
public class _1905CountSubIslands {
    public static void main(String[] args) {
        int[][] grid1 = {
                {1,1,1,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {1,0,0,0,0},
                {1,1,0,1,1},
        };
        int[][] grid2 = {
                {1,1,1,0,0},
                {0,0,1,1,1},
                {0,1,0,0,0},
                {1,0,1,1,0},
                {0,1,0,1,0},
        };
        _1905CountSubIslands s = new _1905CountSubIslands();
        int num = s.countSubIslands(grid1, grid2);
        System.out.println("num = " + num);
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //if a cell in grid2 is island but in grid1 is sea, it must not be a sub island, fill it with sea
                if(grid2[i][j] == 1 && grid1[i][j] == 0){
                    floodFill(grid2,i,j);
                }
            }
        }
        //now the rest cells in grid2 must be the sub island, get the result
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid2[i][j] == 1){
                    res++;
                    floodFill(grid2,i,j);
                }
            }
        }
        return res;
    }

    private void floodFill(int[][] grid, int i, int j){
        if(outOfArea(grid,i,j)){
            return;
        }
        if(grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        floodFill(grid,i-1,j);
        floodFill(grid,i+1,j);
        floodFill(grid,i,j-1);
        floodFill(grid,i,j+1);
    }

    private boolean outOfArea(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n){
            return true;
        }
        return false;
    }

}
