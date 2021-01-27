package solutions;

import java.util.Arrays;

/**
 * NO.16 Three Sum Closest
 * Keywords:   Two pointer, Colliding pointer
 * Difficulty: Medium
 * Company:    Bloomberg
 */
public class _016ThreeSumClosest {
    /**
     * Train of thought 1：
     * 遍历数组，如果3个数之和目标值相等则直接返回，如果当前差值小于最小差值，则更新最小差值和返回结果
     * 时间复杂度：O(n^3)
     */
    public int threeSumClosest(int[] nums, int target) {
        int miniBalance = 0x7fffffff;
        int ret=0; //记录返回结果
        for(int i = 0; i < nums.length-2; i++){
            for(int j = i + 1; j < nums.length-1; j++){
                for(int k = j + 1; k< nums.length; k++){
                    int sum = nums[i]+nums[j]+nums[k]; //三个数的和
                    int currentBalance = Math.abs(sum- target); //和与目标值的差额
                    if( currentBalance == 0) //如果差额为0直接返回
                        return sum;
                    if( currentBalance < miniBalance){ //如果当前差额小于最小差额，
                        miniBalance = currentBalance;//更新最小差额
                        ret = sum;//并更新返回值
                    }
                }
            }
        }
        return ret;
    }

    /**
     * Train of thought 2： 排序并降维，利用对撞指针的性质解题
     * 排序，取当前索引，当前索引下一个索引，以及最后一个索引，进行对撞指针操作
     * 时间复杂度：O(nlogn) + O(n^2)
     */
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = nums[0]+nums[1]+nums[2];
        int miniBalance = Math.abs(ret - target);
        for(int i = 0; i < nums.length; i++){
            int left = i + 1;
            int right = nums.length-1;
            int t = target - nums[i] ; // new target
            while( left < right ){

                if(nums[left]+nums[right] == t)
                    return nums[left] + nums[right] + nums[i];
                else{
                    //update the closest
                    if(Math.abs(nums[left]+nums[right] - t) < miniBalance){
                        miniBalance = Math.abs(nums[left]+nums[right] - t);
                        ret = nums[left] + nums[right] + nums[i];
                    }
                    // move pointers
                    if(nums[left]+nums[right] < t)
                        left++;
                    else //nums[left]+nums[right] > t
                        right--;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        _016ThreeSumClosest t = new _016ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(t.threeSumClosest2(nums, target));

    }
}
