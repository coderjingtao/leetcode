package solutions.amazon;

/**
 * 2340 Minimum Adjacent Swap to Make a Valid Array
 * Keywords:
 * Difficulty: Medium
 * Company: Amazon
 */
public class _2340MinimumAdjacentSwapToMakeValidArray {

    public int minimumSwaps(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return 0;
        }
        int maxVal = nums[0];
        int maxIndex = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] >= maxVal){
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        int minVal = nums[nums.length-1];
        int minIndex = nums.length-1;
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i] <= minVal){
                minVal = nums[i];
                minIndex = i;
            }
        }
        int swapStep = (nums.length - 1 - maxIndex) + (minIndex - 0);
        return maxIndex >= minIndex ? swapStep : swapStep-1;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,5,3,1};
        _2340MinimumAdjacentSwapToMakeValidArray s = new _2340MinimumAdjacentSwapToMakeValidArray();
        int steps = s.minimumSwaps(nums);
        System.out.println("steps = " + steps);
    }

}
