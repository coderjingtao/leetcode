package solutions;

/**
 * NO.26 Remove Duplicates from Sorted Array
 * Keywords:   Array, two pointer
 * Difficulty: Easy
 * Company:    Facebook, Microsoft, Bloomberg
 */
public class _026RemoveDuplicates {
    /**
     * 思路：用[0...tail) 区间保存所有不重复的元素,用索引i扫描一遍数组，只要后一个元素比它大则赋值给nums[tail],同时tail往后移动一位
     * 算法复杂度：O(n),空间复杂度:O(1)
     */
    public int removeDuplicates(int[] nums) {

        int tail = 1; // [0,tail) 区间内元素不重复，因为[0,0] 本身就不重复
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i+1] != nums[i]){
                nums[tail] = nums[i+1];
                tail++;
            }
        }
        return tail;
    }

    public static void main(String[] args) {
        _026RemoveDuplicates s = new _026RemoveDuplicates();
        int[] nums = {0,0,1,1,1,2,2,3,3,4,4};
        int ret = s.removeDuplicates(nums);
        System.out.println("result="+ret);
        for(int n : nums)
            System.out.print(n+",");

    }
}
