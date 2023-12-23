package solutions.amazon;

import java.util.Arrays;

/**
 * NO.2357 Make Array Zero by Subtracting Equal Amounts
 * Keywords: Array
 * Difficulty: Easy
 * Company: Amazon
 */
public class _2357MakeArrayZero {
    public int minimumOperations(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        return dfs(nums,0);
    }

    private int dfs(int[] sortedNums, int res){
        if(sortedNums[sortedNums.length-1] == 0){
            return res + 0;
        }
        if(sortedNums.length == 1){
            return res + 1;
        }
        int x = 0;
        for(int i = 0; i < sortedNums.length; i++){
            if(sortedNums[i] > 0){
                x = sortedNums[i];
                break;
            }
        }
        for(int i = 0; i < sortedNums.length; i++){
            sortedNums[i] = sortedNums[i] - x;
        }
        return dfs(sortedNums, res+1);
    }

    public static void main(String[] args) {
        _2357MakeArrayZero solution = new _2357MakeArrayZero();
        int[] nums = {0};
        int res = solution.minimumOperations(nums);
        System.out.println("res = " + res);
    }
}
