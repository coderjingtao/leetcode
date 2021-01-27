package solutions;

import java.util.*;

/**
 * NO.350 Intersection of Two Arrays II
 * Keywords:   HashMap, ArrayList
 * Difficulty: Easy
 * Company:    Two Sigma
 */
public class _350IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
        for(int n: nums1){
            int count = map1.getOrDefault(n, 0);
            map1.put(n, count+1);
        }
        List<Integer> intersection = new ArrayList<Integer>();
        for(int m: nums2){
            if(map1.containsKey(m) && map1.get(m) > 0){
                intersection.add(m);
                map1.put(m, map1.get(m)-1);
            }
        }
        int[] result = new int[intersection.size()];
        for(int i = 0; i < intersection.size(); i++)
            result[i] = intersection.get(i);
        return result;
    }

    public static void main(String[] args) {

        _350IntersectionOfTwoArrays2 i = new _350IntersectionOfTwoArrays2();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] res = i.intersect(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

}
