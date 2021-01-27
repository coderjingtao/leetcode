package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * NO.15 Three Sum
 * Keywords:   Two pointer, Colliding pointer
 * Difficulty: Medium
 * Company:    Facebook, Microsoft, Amazon, Bloomberg
 */
public class _015ThreeSum {
    /**
     * 思想: Two pointer 对撞指针
     * 注意：返回的数组中不能包含重复的3元组，例如[-1, 1, 0]和[0, -1, 1]视为重复
     * 这样就不能按照正常的索引顺序依次判断了，会产生重复元素的三元组
     * 思路：
     * 1. 对数组排序排序
     * 2. 根据指针对撞方法，并取得当前元素的下一个元素，以及最后一个元素
     * 3. 判断当前元素的下一个元素，以及最后一个元素之和，来判断如何移动指针
     * 4. 由于不能出现重复元素，移动指针时，如果下一位的值和当前值一样，则继续移动，直到不一样为止
     * 时间复杂度：O(n^2)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3)
            return ret;
        Arrays.sort(nums);
        if(nums[0]>0)
            return ret;

        int aIndex=0;
        while(aIndex < nums.length-1){
            int bIndex = aIndex + 1;
            int cIndex = nums.length-1;
            while(bIndex < cIndex){
                //1.如果满足条件
                if( nums[bIndex] + nums[cIndex] == -nums[aIndex]){
//            		List<Integer> zeroList = new ArrayList<Integer>();
//            		zeroList.add(nums[aIndex]);
//            		zeroList.add(nums[bIndex]);
//            		zeroList.add(nums[cIndex]);
//            		ret.add(zeroList);
                    //简化代码
                    ret.add(Arrays.asList(nums[aIndex],nums[bIndex],nums[cIndex]));
                    //继续查找其他的元素
                    bIndex = next_index(nums, bIndex);//向右移动bIndex,到下一个元素值不相等的位置
                    cIndex = prev_index(nums, cIndex);//向左移动cIndex,到下一个元素值不相对的位置
                }
                //2.如果两数之和小，则向右移动b指针
                else if(nums[bIndex] + nums[cIndex] < -nums[aIndex])
                {
                    bIndex = next_index(nums, bIndex);
                }
                //3.如果两数之和大，则向左移动c指针
                else{
                    cIndex = prev_index(nums, cIndex);
                }
            }
            aIndex = next_index(nums, aIndex);
        }
        return ret;
    }

    //向右移动指针到下一个不相等的元素，并返回指针索引
    private int next_index(int[] nums, int index){
        for(int i = index+1; i < nums.length; i++){
            if(nums[index] != nums[i])
                return i;
        }
        return nums.length;
    }

    //向左移动指针到下一个不相等的元素，并返回指针索引
    private int prev_index(int[] nums, int index){
        for(int i= index-1; i >= 0; i--){
            if(nums[index] != nums[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        _015ThreeSum t = new _015ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(t.threeSum(nums));
    }
}
