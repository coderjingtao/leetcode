package solutions.amazon;

/**
 * 348 Design Tic-Tac-Toe
 * Keywords: oop, design
 * Difficulty: Medium
 * Company: Facebook, Amazon
 */
public class _348DesignTicTacToe {
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe(3);
        int move = t.move(1, 2, 2);
        System.out.println(move);
        move = t.move(0, 2, 1);
        System.out.println(move);
        move = t.move(0, 0, 2);
        System.out.println(move);
        move = t.move(2, 0, 1);
        System.out.println(move);
        move = t.move(0, 1, 2);
        System.out.println(move);
        move = t.move(1, 1, 1);
        System.out.println(move);
    }
}

class TicTacToe {

    private int[][] grid;
    private int n;
    private int nextPlayer = 0;
    private int countMove = 0;

    public TicTacToe(int n) {
        this.n = n;
        grid = new int[n][n];
    }

    public int move(int row, int col, int player) {
        if(!validPlayer(player)){
            return 0;
        }
        if(!validMove(row,col)){
            return 0;
        }
        countMove++;
        grid[row][col] = player;
        if(isWin(row,col)){
            return player;
        }
        return 0;
    }

    private boolean validPlayer(int player){
        if (countMove != 0) {
            if (nextPlayer != player) {
                System.out.println("should be the ture for player " + nextPlayer);
                return false;
            }
        }
        nextPlayer = player == 1 ? 2 : 1;
        return true;
    }

    private boolean validMove(int row, int col){
        if(row < 0 || col < 0 || row >= n || col >= n){
            System.out.println("out of boundary");
            return false;
        }
        if(grid[row][col] != 0){
            System.out.println("cell is not empty");
            return false;
        }
        return true;
    }
    private boolean isWin(int row, int col){
        return isVerticalWin(row,col) || isHorizontalWin(row,col) || isPrimaryDiagonalWin(row,col) || isSecondaryDiagonalWin(row,col);
    }

    //vertical
    private boolean isVerticalWin(int row, int col){
        int w = grid[row][col];
        for(int i = 0; i < n; i++){
            if(grid[i][col] != w){
                return false;
            }
        }
        return true;
    }
    //horizontal
    private boolean isHorizontalWin(int row, int col){
        int w = grid[row][col];
        for(int j = 0; j < n; j++){
            if(grid[row][j] != w){
                return false;
            }
        }
        return true;
    }
    private boolean isPrimaryDiagonalWin(int row, int col){
        int w = grid[row][col];
        if(row - col == 0){
            for(int i = 0; i < n; i++){
                if(grid[i][i] != w){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    private boolean isSecondaryDiagonalWin(int row, int col){
        int w = grid[row][col];
        if(row + col == n -1){
            for(int i = 0; i < n; i++){
                int j = (n-1) - i;
                if(grid[i][j] != w){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
