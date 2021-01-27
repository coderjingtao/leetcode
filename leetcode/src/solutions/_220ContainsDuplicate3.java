package solutions;

import java.util.TreeSet;

/**
 * NO.220 Contains Duplicate III
 * Keywords:   TreeSet, Binary Search Tree, Sliding Window
 * Difficulty: Medium
 * Company:    Airbnb
 */
public class _220ContainsDuplicate3 {
    /**
     * Solution: 查找表 + 滑动窗口
     * 和219 Contains Duplicate II 思路一致，用 k来限制集合的大小，用t来满足条件
     * 遍历数组，看对每一个新元素v，是否在集合中存在着那么一个元素x，使其满足公式 |v-x| <=t
     * 转化公式可以得到：即是否集合中查找是否存在一个元素x,并满足 v-t <= x <= v+t 条件
     * 再次转换为：在集合中如果存在元素：ceiling(v-t)，并且这个元素小于等于v+t
     * 或：		在集合中如果存在元素：floor(v+t)，并且这个元素大于等于v+t
     * 由于要使用ceiling()或floor()方法，所以需用到TreeSet
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            int v = nums[i];
            //大于等于v-t的元素存在，并且这个元素小于等于v+t
            if( set.ceiling(v-t) != null && set.ceiling(v-t) <= v+t){
                return true;
            }
            set.add(nums[i]);
            if(set.size() == k+1)
                set.remove(nums[i-k]);
        }
        return false;
    }

    //当整数足够大时，v+t会产生整型溢出的问题，把 int 改为long
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {

        TreeSet<Long> set = new TreeSet<Long>();
        for(int i = 0; i < nums.length; i++){
            int v = nums[i];
            //大于等于v-t的元素存在，并且这个元素小于等于v+t
            if( set.ceiling((long)v-(long)t) != null && set.ceiling((long)v-(long)t) <= (long)v+(long)t){
                return true;
            }
            set.add((long)nums[i]);
            if(set.size() == k+1)
                set.remove((long)nums[i-k]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        int t = 0;
        _220ContainsDuplicate3  c = new _220ContainsDuplicate3();
        System.out.println(c.containsNearbyAlmostDuplicate2(nums, k, t));
    }
}
