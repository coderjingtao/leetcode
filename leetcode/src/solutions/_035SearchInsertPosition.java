package solutions;

/**
 * NO.35 Search Insert Position
 * Keywords:   Array, two pointer
 * Difficulty: Easy
 * Company:
 */
public class _035SearchInsertPosition {

    //two pointers
    public int searchInsert(int[] nums, int target) {

        if(nums.length == 1){ // when the size of array is one
            return target <= nums[0] ? 0 : 1;
        }
        int l = 0;
        while( l+1 < nums.length){
            if(target <= nums[l])
                return l;
            if(nums[l] < target && nums[l+1] >= target)
                return l+1;
            if(nums[l+1] < target)
                l++;
        }
        return nums.length;
    }

    //improvement: one pointer
    public int searchInsert2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if( target <= nums[i] )
                return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        _035SearchInsertPosition s = new _035SearchInsertPosition();
        int[] nums = {1,3,4,5};
        int target = 2;
        System.out.println(s.searchInsert2(nums,target));
    }
}
