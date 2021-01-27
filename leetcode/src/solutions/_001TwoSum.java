package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * NO.1 Two Sum
 * Keywords:   Array, HashMap
 * Difficulty: Easy
 * Company:    Facebook, Linkedin, Microsoft, Amazon, Uber, Yelp, Apple, Bloomberg, Yahoo, Airbnb
 */
public class _001TwoSum {
    /*
  * 由于给定的数组并不是有序的，所以使用对撞指针并不是最优解
  * Idea：
  * 把数组中的元素n依次放入set中，如果(target-n)也存在set中,则这两个数则一定是其中的一个解（该问题中说只存在一个解）
  * 由于需要返回的是这两个数的索引，所以需要记录两个元素的索引值，故用map<element:index>替换set
  * Note:
  * 由于可能存在值相等的两个元素（例如 [4,4] target=8），故不能一次性把所有元素全部放入map，否则会后者会覆盖前者
  * 所以取出当前元素时，只把它之前的元素放入map，比较target-n在map中是否存在，如果不存在解，再把该元素放入map，这时覆盖也无所谓了
  */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            int one = nums[i];
            int two = target - one;
            if(map.containsKey(two))
                return new int[]{ map.get(two) , i };
            map.put(one, i);
        }
        return null;
    }

    public static void main(String[] args) {
        _001TwoSum i = new _001TwoSum();
        int[] nums1 = {2, 7, 11, 15};
        int target = 100;
        int[] res = i.twoSum(nums1, target);
        for(int n: res)
            System.out.println(n);
    }
}
