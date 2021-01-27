package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * NO.219 Contains Duplicate II
 * Keywords:   HashSet, Sliding Window
 * Difficulty: Easy
 * Company:    Airbnb
 */
public class _219ContainsDuplicate2 {
    /**
     * Idea:
     * 从头开始把每一个新元素都放到一个固定长度为k+1的set中（由于2个索引差值<=k，所以set中最多有k+1个元素）
     * 当size==k+1时，即set要把最开始放入的元素删除，这样才能添加一个新的元素进来
     * 进而判断新进来的元素在set中是否已经存在，存在则存在相等的元素，重复这个过程，直到不存在返回false
     * 时间复杂度：O(n)
     * 空间复杂度：O(k)
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if(set.size() == k+1) //保证set的大小是 k+1
                set.remove(nums[i-k]);//删除最前面的元素才能保证下次添加进去元素后set又重新是k+1个
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        int k = 1;
        _219ContainsDuplicate2  c = new _219ContainsDuplicate2();
        System.out.println(c.containsNearbyDuplicate(nums, k));
    }
}
