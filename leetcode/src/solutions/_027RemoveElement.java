package solutions;

/**
 * NO.27 Remove Element
 * Keywords:   Array, two pointer
 * Difficulty: Easy
 * Company:
 */
public class _027RemoveElement {
    /**
     * 思路：用[0...k) 区间保存所有不等于val的元素,用索引i扫描一遍数组，遇到不等于val的元素则交换与k的位置,同时k加1
     * 算法复杂度：O(n),空间复杂度:O(1)
     */
    public int removeElement(int[] nums, int val) {
        int k = 0; // [0,k) 区间内不等于val
        for(int i=0; i<nums.length;i++){
            if(nums[i] != val ){
                swap(nums,k,i);
                k++;
            }
        }
        return k;
    }
    /**
     * 优化：如果 k和i不相等时再交换位置
     */
    public int removeElement2(int[] nums, int val) {
        int k = 0; // [0,k) 区间内不等于val
        for(int i=0; i<nums.length;i++){
            if(nums[i] != val ){
                if(k!=i){
                    swap(nums,k,i);
                    k++;
                }
                else
                    k++;
            }
        }
        return k;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        _027RemoveElement s = new _027RemoveElement();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int ret = s.removeElement2(nums, val);
        for(int n : nums)
            System.out.println(n);
        System.out.println(ret);
    }
}
