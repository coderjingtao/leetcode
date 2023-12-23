package solutions.amazon;

/**
 * NO.2104 Sum of Subarray Ranges
 * Keywords: Array Stack Monotonic Stack
 * Difficulty: Medium
 * Company: Amazon
 */
public class _2104SumOfSubarrayRanges {

    public long subArrayRanges(int[] nums) {
        long res = 0;
        for(int i = 0; i < nums.length-1; i++){
            int max = nums[i], min = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                max = Math.max(max,nums[j]);
                min = Math.min(min,nums[j]);
                res += max - min;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,-2,-3,4,1};
        _2104SumOfSubarrayRanges s = new _2104SumOfSubarrayRanges();
        long sum = s.subArrayRanges(nums);
        System.out.println(sum);
    }
}
