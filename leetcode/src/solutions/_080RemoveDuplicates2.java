package solutions;

/**
 * NO.80 Remove Duplicates from Sorted Array II
 * Keywords:   Array, two pointer
 * Difficulty: Medium
 * Company:    Facebook
 */
public class _080RemoveDuplicates2 {
    /**
     * 思路：用[0...tail) 区间保存所有不重复的元素,用索引i扫描一遍数组，只要后一个元素比它大则赋值给nums[tail],同时tail往后移动一位
     * 算法复杂度：O(n),空间复杂度:O(1)
     */
    public int removeDuplicates(int[] nums) {
        int tail = 1; // [0,tail) 区间内元素不重复，因为[0,0] 本身就不重复
        int counter = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] != nums[i]) {
                counter = 0;
                nums[tail] = nums[i + 1];
                tail++;
            } else { //
                counter++;
                if (counter <= 1) {
                    nums[tail] = nums[i + 1];
                    tail++;
                }
            }
        }
        return tail;
    }

    public static void main(String[] args) {
        _080RemoveDuplicates2 s = new _080RemoveDuplicates2();
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int ret = s.removeDuplicates(nums);
        System.out.println("length=" + ret);
        for (int n : nums)
            System.out.print(n + ",");

    }
}
