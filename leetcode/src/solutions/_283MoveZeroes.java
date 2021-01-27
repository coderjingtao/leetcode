package solutions;

/**
 * NO.283 Move Zeroes
 * Keywords:   Array, two pointer
 * Difficulty: Easy
 * Company:    Facebook, Bloomberg
 */
public class _283MoveZeroes {

    /**
     * 思路1：暴力破解，比较2个元素，如果第一个元素为0，第二个元素不为0，则交换位置
     * 算法复杂度 ：O(n^2)
     */
    public void moveZeroes(int[] nums){

        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j < nums.length;j++){
                if(nums[i]==0)
                {
                    if(nums[j]!=0){
                        swap(nums,i,j);
                    }
                }
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 思路2：开辟空间并复制数组，把不为0的元素依次放入nums,然后给后面补0，直到索引到达上界
     * 算法复杂度：O(n),空间复杂度:O(n)
     */
    public void moveZeroes2(int[] nums){
        int[] arr = nums;
        int index = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                nums[index] = nums[i];
                index++;
            }
        }
        while(index < nums.length){
            nums[index] = 0;
            index++;
        }
    }
    /**
     * 思路3：用[0...k) 区间保存所有非0元素,用索引i扫描一遍数组，遇到非0元素则交换与k的位置,同时k加1
     * 算法复杂度：O(n),空间复杂度:O(1)
     */
    public void moveZeroes3(int[] nums){
        int k=0; //[0,k) 保存所有非0元素
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
//                swap(nums,k,i);
//                k++;
                //可以简化为
                swap(nums,k++,i);
            }
        }
    }
    /**
     * 针对moveZeroes3的优化：如果整个数组都是非0元素，上述方法则都需要交换位置
     * 现在保证 如果 k和i不相等时再交换位置
     */
    public void moveZeroes4(int[] nums){
        int k=0; //[0,k) 保存所有非0元素
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                if(k != i){
                    swap(nums,k,i);
                    k++;
                }
                else
                    k++;
            }
        }
    }

    public static void main(String[] args){
        _283MoveZeroes s = new _283MoveZeroes();
        int[] arr = {0,1,0,3,12};
        s.moveZeroes3(arr);
        for(int n:arr)
            System.out.print(n+" ");
    }
}
