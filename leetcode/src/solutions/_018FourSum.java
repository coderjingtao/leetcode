package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * NO.18 Four Sum
 * Keywords:   Two pointer, colliding pointer
 * Difficulty: Medium
 * Company:    Linkedin
 * todo 是否有更好的方法
 */
public class _018FourSum {

    /**
     * 思路：排序，降维成2维，对撞指针
     * 时间复杂度：O(n^3)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int aIndex = 0;
        while(aIndex < nums.length-3){
            int bIndex = aIndex + 1;
            while(bIndex < nums.length-2){
                int cIndex = bIndex + 1;
                int dIndex = nums.length - 1;
                while(cIndex < dIndex){
                    if( nums[aIndex]+nums[bIndex]+nums[cIndex]+nums[dIndex] == target ){
                        ret.add(Arrays.asList(nums[aIndex],nums[bIndex],nums[cIndex],nums[dIndex]));
                        cIndex = next_index(nums, cIndex);
                        dIndex = prev_index(nums, dIndex);
                    }
                    else if(nums[aIndex]+nums[bIndex]+nums[cIndex]+nums[dIndex] < target)
                        cIndex = next_index(nums, cIndex);
                    else
                        dIndex = prev_index(nums, dIndex);
                }
                bIndex = next_index(nums, bIndex);
            }
            aIndex = next_index(nums, aIndex);
        }
        return ret;
    }

    private int next_index(int[] nums, int index){
        for(int i = index+1; i < nums.length; i++)
            if(nums[i] != nums[index])
                return i;
        return nums.length;
    }

    private int prev_index(int[] nums, int index){
        for(int i = index-1; i >= 0; i--)
            if(nums[i] != nums[index])
                return i;
        return -1;
    }

    public static void main(String[] args) {
        _018FourSum f = new _018FourSum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(f.fourSum(nums, 0));
    }
}
