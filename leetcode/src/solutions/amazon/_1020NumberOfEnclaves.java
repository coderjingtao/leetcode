package solutions.amazon;

/**
 * NO.1020 Numbers of Enclaves
 * Keywords: Island
 * Difficulty: Medium
 * Company: Google, Amazon, Microsoft, Adobe
 */
public class _1020NumberOfEnclaves {

    public static void main(String[] args) {
        int[][] grid = {
                {0,1,1,0},
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,0},
        };
        _1020NumberOfEnclaves s = new _1020NumberOfEnclaves();
        int num = s.numEnclaves(grid);
        System.out.println("num = " + num);
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            fillWithSea(grid,i,0);//flood left
            fillWithSea(grid,i,n-1);//flood right
        }
        for(int j = 0; j < n; j++){
            fillWithSea(grid,0,j);//flood up
            fillWithSea(grid,m-1,j);//flood down
        }
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    res++;
                }
            }
        }
        return res;
    }
    //flood the point(i,j) and the adjacency of the point
    private void fillWithSea(int[][] grid, int i, int j){
        if(outOfArea(grid, i, j)){
            return;
        }
        if(grid[i][j] == 0){//already sea
            return;
        }
        grid[i][j] = 0;//fill with sea
        //fill with sea around it : up, down, left and right
        fillWithSea(grid,i-1,j);
        fillWithSea(grid,i+1,j);
        fillWithSea(grid,i,j-1);
        fillWithSea(grid,i,j+1);
    }

    private boolean outOfArea(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n){
            return true;
        }
        return false;
    }
}
