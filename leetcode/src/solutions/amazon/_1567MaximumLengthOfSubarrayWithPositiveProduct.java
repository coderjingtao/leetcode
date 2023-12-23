package solutions.amazon;

/**
 * NO.1567 Maximum Length Of Subarray With Positive Product
 * Keywords:
 * Difficulty: Medium
 * Company: Amazon
 */
public class _1567MaximumLengthOfSubarrayWithPositiveProduct {

    /**
     * i = 当前遍历数组nums的索引值
     * zeroPos = 最近的出现0的位置/索引值
     * firstNegativePos = 第一个负数的的位置/索引值
     * countNegative = 目前为止负数的数量
     * maxLen = 结果/最大子数组的长度
     * 基本逻辑：
     * 1.如果当前数据值nums[i] = 0, 重置游戏，也就是重置负数相关的所有数据 countNegative, firstNegativePos
     * 2.如果当前数据值nums[i] < 0，累加 countNegative； 如果是第一个负数，更新firstNegativePos
     * 3.根据负数的奇偶来更新当前子数组的长度结果：
     *  3.1 countNegative为偶数： Len of Subarray = i - zeroPos
     *  3.2 countNegative为奇数： Len of Subarray = i - firstNegativePos
     * @param nums 数组  Time Complexity = O(n), Space Complexity = O(1)
     * @return maxLen
     */
    public int getMaxLen(int[] nums) {
        int zeroPos = -1, firstNegativePos = -1;
        int countNegative = 0;
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                countNegative++;
                if(firstNegativePos == -1){
                    firstNegativePos = i;
                }
            }
            if(nums[i] == 0){
                zeroPos = i;
                firstNegativePos = -1;
                countNegative = 0;
            }else{
                if(countNegative % 2 == 0){
                    maxLen = Math.max(maxLen, i - zeroPos);
                }else{
                    maxLen = Math.max(maxLen, i - firstNegativePos);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,-2,-3,-4};
        _1567MaximumLengthOfSubarrayWithPositiveProduct s = new _1567MaximumLengthOfSubarrayWithPositiveProduct();
        int maxLen = s.getMaxLen(nums);
        System.out.println("maxLen = " + maxLen);
    }
}
