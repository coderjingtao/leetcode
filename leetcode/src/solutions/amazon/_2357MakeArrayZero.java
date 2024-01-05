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
        int[] nums = {1,5,0,3,5};
        int res = solution.minimumOperations3(nums);
        System.out.println("res = " + res);
    }

    public int minimumOperations2(int[] nums) {
        Arrays.sort(nums);
        int[] subtract = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            subtract[i] = i-1<0 ? nums[i] : nums[i] - nums[i-1];
        }
        return (int)Arrays.stream(subtract).filter(x -> x > 0).count();
    }

    public int minimumOperations3(int[] nums) {
        return (int)Arrays.stream(nums).filter(x -> x > 0).distinct().count();
    }
}
