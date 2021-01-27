package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * NO.215 Kth Largest Element in an Array
 * Keywords:
 * Difficulty: Medium
 * Company:    Facebook, Microsoft, Amazon, Apple, Bloomberg
 * todo : pivot algorithm of quick sort
 */
public class _215KthLargestElement {

    /**
     * Solution 1
     * 思路：从大到小排序，并找到(k-1)的索引所对应的元素
     * Time complexity = O(nlogn)
     */
    public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int n: nums)
            list.add(n);
        Collections.sort(list,Collections.reverseOrder());
        return (int)list.get(k-1);
    }
    /**
     * Solution 2
     * 思路：从小到大默认排序，并找到(nums.length - k)的索引所对应的元素
     * Time complexity = O(nlogn)
     */
    public int findKthLargest2(int[] nums, int k) {
        if(nums.length == 0) return Integer.MAX_VALUE;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    public static void main(String[] args) {
        _215KthLargestElement t = new _215KthLargestElement();
        int[] nums = {3,2,1,5,6,4};
        int k=2;
        System.out.println(t.findKthLargest2(nums,k));
    }
}
