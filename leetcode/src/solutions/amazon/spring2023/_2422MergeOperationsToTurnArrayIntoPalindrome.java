package solutions.amazon.spring2023;

/**
 * 2422 Merge Operations to Turn Array into a Palindrome
 * Keywords: Collision Two Pointers
 * Difficulty: Medium
 * Company: Amazon
 */
public class _2422MergeOperationsToTurnArrayIntoPalindrome {

    public int minimumOperations(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int operation = 0;
        while(left < right){
            if(nums[left]  == nums[right]){
                left++;
                right--;
            }else if(nums[left] < nums[right]){
                int merge = nums[left] + nums[left+1];
                nums[left+1] = merge;
                left++;
                operation++;
            }else{ // nums[left] > nums[right]
                int merge = nums[right] + nums[right - 1];
                nums[right-1] = merge;
                right--;
                operation++;
            }
        }
        return operation;
    }

    public static void main(String[] args) {
        _2422MergeOperationsToTurnArrayIntoPalindrome s = new _2422MergeOperationsToTurnArrayIntoPalindrome();
        int[] nums = {4,3,2,1,2,3,1};
        int res = s.minimumOperations(nums);
        System.out.println("res = " + res);
    }
}
