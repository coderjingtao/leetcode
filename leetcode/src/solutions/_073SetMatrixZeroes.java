package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * NO.73 Set Matrix Zeroes
 * Keywords:   Array Matrix
 * Difficulty: Medium
 * Company:    Microsoft, Amazon
 * todo improve it to use constant space
 */
public class _073SetMatrixZeroes {

    /**
     * 思路：把matrix遍历一遍，记录元素是0的所有位置的横纵坐标，最后把记录的横纵坐标所在的行和列置为0
     * 空间复杂度：O(m+n)
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        for(int i=0; i< matrix.length; i++)
            for(int j=0; j< matrix[i].length;j++)
                if(matrix[i][j]==0){
                    setX.add(i);
                    setY.add(j);
                }
        for(int i=0; i<matrix.length; i++)
            for(int j=0; j<matrix[i].length;j++){
                if(setX.contains(i) || setY.contains(j)){
                    matrix[i][j]=0;
                }
            }
    }

    public static void main(String[] args) {
        _073SetMatrixZeroes r = new _073SetMatrixZeroes();
        int[][] matrix1 = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        int[][] matrix2= {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        r.setZeroes(matrix1);
        for(int i=0;i<matrix1.length; i++){
            for(int j=0;j<matrix1[i].length;j++)
                System.out.print("["+matrix1[i][j]+"],");
            System.out.println();
        }
    }
}
