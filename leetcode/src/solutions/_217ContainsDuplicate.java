package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * NO.217 Contains Duplicate
 * Keywords:   HashSet
 * Difficulty: Easy
 * Company:    Yahoo, Airbnb
 */
public class _217ContainsDuplicate {
    /**
     * Idea:
     * 把每一个元素依次放入set中，如果下一个元素可以在set中找到，则说明存在重复
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        _217ContainsDuplicate c = new _217ContainsDuplicate();
        int[] nums = {1,1,1,3,3,4,3,2,4,2 };
        System.out.println(c.containsDuplicate(nums));
    }
}
