package solutions.amazon;

/**
 * 2221 Fina Triangular Sum of an Array
 * Keywords:
 * Difficulty: Medium
 * Company: Amazon
 */
public class _2221FindTriangularSumOfAnArray {

    public int triangularSum(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] next = new int[nums.length-1];
        for(int i = 0; i < nums.length-1; i++){
            next[i] = (nums[i] + nums[i+1]) % 10;
        }
        return triangularSum(next);
    }

    public static void main(String[] args) {
        _2221FindTriangularSumOfAnArray s = new _2221FindTriangularSumOfAnArray();
        int[] nums = {1,2,3,4,5};
        int res = s.triangularSum(nums);
        System.out.println("res = " + res);
    }

}
