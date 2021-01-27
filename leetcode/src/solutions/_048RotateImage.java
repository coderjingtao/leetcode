package solutions;

/**
 * NO.48 Rotate Image
 * Keywords:   Array Matrix
 * Difficulty: Medium
 * Company:    Microsoft, Amazon
 */
public class _048RotateImage {
    /**
     * 思路1：找到每个坐标的变化规律
     * 创建一个新的矩阵去记录变化后的结果，再把记录拷贝到原来的矩阵中，但明显不符合题意
     * 题目中要求不能创建新的矩阵，必须原地in-place进行变化
     */
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        int[][] newMatrix = new int[n][n];
        for(int i=0; i < n; i++){
            for(int j=0; j< n; j++){
                if(i == 0){
                    newMatrix[j][n-1]= matrix[i][j];
                }
                else if(i==n-1){
                    newMatrix[j][0] = matrix[i][j];
                }
                else{
                    newMatrix[j][(n-1)-i] = matrix[i][j];
                }
            }
        }
        for(int i=0; i< n ; i++){
            for(int j=0; j< n ; j++){
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }

    /**
     * Improvement: In-place
     * 四角轮转法：所以坐标只需要四分之一的元素，就能完成所有的轮转
     */
    public void rotate2(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        int len = matrix.length;
        for(int i = 0;i< len/2;i++){
            for(int j = i; j < len- 1 - i ; j++){
                int temp = matrix[i][j]; //四角轮转
                matrix[i][j] = matrix[len-1-j][i];
                matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j] = matrix[j][len-1-i];
                matrix[j][len-1-i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        _048RotateImage r = new _048RotateImage();
        int[][] matrix1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] matrix2= {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        r.rotate2(matrix2);
        for(int i=0;i<matrix2.length; i++){
            for(int j=0;j<matrix2.length;j++)
                System.out.print("["+matrix2[i][j]+"],");
            System.out.println();
        }
    }
}
