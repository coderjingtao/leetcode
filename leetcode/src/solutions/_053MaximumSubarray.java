package solutions;

import java.util.Arrays;

/**
 * NO.53 Maximum Subarray
 * Keywords:   Array, two pointer
 * Difficulty: Easy
 * Company:
 */
public class _053MaximumSubarray {

    //slide window
    public int maxSubArray(int[] nums) {
        int l = 0;
        int r = 0; // nums[l ... r] --> slide window
        int max = nums[0];
        while( r+1 < nums.length ){

            int sum = getSum(l,r+1,nums);
            if(sum >= max){
                r++;
            }else{
                l++;
            }
            if( nums[r+1] >= 0 && nums[l] >= 0){
                r++;
            }
            else if(nums[r+1] >= 0 && nums[l] < 0){
                r++;
                l++;
            }
            else if(nums[r+1] < 0 && nums[l] >= 0){
                r++;
            }
            else if(nums[r+1] < 0 && nums[l] < 0){
                r++;
                l++;
            }

            max = Math.max(max,sum);
        }
        return max;
    }

    private int getSum(int l, int r, int[] nums){
        int sum = 0;
        for(int i = l; i<=r; i++){
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        _053MaximumSubarray m = new _053MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(m.maxSubArray(nums));
    }
}
