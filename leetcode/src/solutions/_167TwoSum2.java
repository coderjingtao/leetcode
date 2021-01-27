package solutions;

/**
 * NO.167 Two Sum II - Input array is sorted
 * Keywords:   Array, two pointer, colliding pointer
 * Difficulty: Easy
 * Company:    Amazon
 */
public class _167TwoSum2 {
    /**
     * 思路：对撞指针
     * 充分利用数组是有序的这一特征，分别从左右两端取出元素left和right，然后相加，与目标数字比较
     * 1. 两数之和与目标数字相等，则返回索引值
     * 2. 两数之和比目标数字小，则需要两数之和要大一点，则需要左侧的索引向右移动
     * 3. 两数之和比目标数字大，则需要两数之和要小一点，则需要右侧的索引向左移动
     * 算法复杂度：O(n),空间复杂度:O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0; //最左侧索引
        int right = numbers.length-1; //最右侧索引
        while (left < right) // left == right时，为1个元素，不符合题意，需要返回2个数
        {
            if( numbers[left] + numbers[right] == target )
                return new int[]{left+1,right+1};
            else if( numbers[left] + numbers[right] < target)
                left ++;
            else // numbers[left] + numbers[right] > target
                right --;
        }
        return null;
    }


    public static void printArray(int[] nums){
        for(int e: nums)
            System.out.print(e+",");
        System.out.println();
    }

    public static void main(String[] args) {
        _167TwoSum2 s =  new _167TwoSum2();
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] ret = s.twoSum(numbers, target);
        printArray(ret);
    }
}
