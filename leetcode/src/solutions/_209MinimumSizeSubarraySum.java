package solutions;

/**
 * NO.209 Minimum Size Subarray Sum
 * Keywords:   Array, two pointer, Sliding Window
 * Difficulty: Medium
 * Company:    Facebook
 */
public class _209MinimumSizeSubarraySum {

    /**
     * 思路：滑动窗口 Sliding Window
     * 给定一个子数组 nums[left,right]，初始值位于整个数组的左侧
     * 如果这个数组之和sum小于给定的值s， 则右侧指针向右移动，如果之和sum大于s则左侧指针向右移动，这样遍历一遍数组
     * 算法复杂度：O(n),空间复杂度:O(1)
     */
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = -1; //nums[left,right] 初始值不包括任何元素
        int sum = 0;
        int minLength = nums.length+1; // 数组长度的初始值不能是数组的长度，可能会有不存在的情况

        while(left < nums.length){ //极限的情况是左指针和右指针相等，都 == nums.length-1，所以只限定左指针即可

            if( right+1 < nums.length && sum < s){
                right++; //需要保证指针不要越界
                sum += nums[right];
            }
            else{ // sum >=s
                sum -= nums[left];
                left ++;
            }

            if(sum >= s)
                minLength = Math.min(minLength, right-left+1);
        }

        if(minLength == nums.length+1) //如果最小值没有更新，依然是初始值，则表示不存在这样的子数组
            return 0;
        return minLength;
    }

    public static void main(String[] args) {
        _209MinimumSizeSubarraySum m = new _209MinimumSizeSubarraySum();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(m.minSubArrayLen(7, nums));
    }
}
