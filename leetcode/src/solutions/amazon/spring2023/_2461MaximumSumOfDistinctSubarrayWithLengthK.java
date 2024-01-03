package solutions.amazon.spring2023;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2461 Maximum Sum of Distinct SubArrays with Length K
 * Keywords: sliding window, classic
 * Difficulty: Medium
 * Company: Amazon
 */
public class _2461MaximumSumOfDistinctSubarrayWithLengthK {

    //Exceed Time Limit
    public static long maximumSubarraySum(int[] nums, int k) {
        int left = 0;
        int right = left + k;
        //subarray = nums[left,right)
        long max = 0;
        while(right <= nums.length){
            Set<Integer> set = new HashSet<>();
            set.add(nums[left]);
            long sum = nums[left];
            for(int i = left + 1; i < right; i++){
                if(set.contains(nums[i])){
                    sum = 0;
                    break;
                }
                set.add(nums[i]);
                sum += nums[i];
            }
            max = Math.max(max,sum);
            left++;
            right++;
        }
        return max;
    }

    public static long maximumSubarraySum2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        long sum = 0;
        long max = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            //at the moment, the left boundary index = i - k + 1
            if(i >= k - 1){
                if(map.size() == k){
                    max = Math.max(max,sum);
                }
                sum -= nums[i-k+1];
                map.put(nums[i-k+1],map.get(nums[i-k+1])-1);
                if(map.get(nums[i-k+1]) == 0){
                    map.remove(nums[i-k+1]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {9,9,9,1,2,3};
        int k = 3;
        long res = maximumSubarraySum2(nums, k);
        System.out.println("res = " + res);
    }
}
