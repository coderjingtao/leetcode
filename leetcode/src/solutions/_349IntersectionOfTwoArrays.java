package solutions;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * NO.349 Intersection of Two Arrays
 * Keywords:   HashSet, ArrayList
 * Difficulty: Easy
 * Company:    Two Sigma
 */
public class _349IntersectionOfTwoArrays {

    //查找表算法之 hash表的使用, HashSet 缺点：失去了原有数据的顺序性
    //时间复杂度：O(n)
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> intersection = new HashSet<Integer>();
        for(int n: nums1)
            set1.add(n);
        for(int m: nums2)
            if(set1.contains(m))
                intersection.add(m);
        int[] result = new int[intersection.size()];
        int index = 0;
        Iterator<Integer> it = intersection.iterator();
        while(it.hasNext()){
            result[index] = it.next();
            index++;
        }
        return result;
    }

    //improvement: intersection uses ArrayList instead of HashSet
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        List<Integer> intersection = new ArrayList<Integer>();
        for(int n: nums1)
            set1.add(n);
        for(int m: nums2)
            if(set1.remove(m)) //删除成功返回true,删除成功则代表nums2中的元素在nums1中存在
                intersection.add(m);
        int[] result = new int[intersection.size()];
        for(int i=0; i< intersection.size(); i++)
            result[i] = intersection.get(i);
        return result;
    }

    //improvement: for java 8
    public int[] intersection3(int[] nums1, int[] nums2) {
        Integer[] a = Arrays.stream(nums1).boxed().toArray( Integer[]::new );
        Set<Integer> set1 = new HashSet<>(Arrays.asList(a));
        Set<Integer> interSet = new HashSet<>();
        for(int ele : nums2)
            if(set1.contains(ele))
                interSet.add(ele);
        return interSet.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        _349IntersectionOfTwoArrays i = new _349IntersectionOfTwoArrays();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] res = i.intersection3(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
