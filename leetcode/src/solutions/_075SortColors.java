package solutions;

/**
 * NO.75 Sort Colors
 * Keywords:   Array, two pointer
 * Difficulty: Medium
 * Company:    Facebook
 */
public class _075SortColors {
    public void sortColors(int[] nums){
        int[] count = new int[3]; //count[0] red个数, count[1] white个数, count[2] blue个数
        //1.计算并存储每种颜色的个数
        for(int i = 0; i < nums.length; i++){
            count[nums[i]]++;
        }
        //2.在按照个数把nums按照索引index重新赋值
        int index = 0;
        for(int i=0; i<count[0];i++)
            nums[index++]=0;
        for(int i=0; i<count[1];i++)
            nums[index++]=1;
        for(int i=0; i<count[2];i++)
            nums[index++]=2;
    }

    public void sortColors2(int[] nums){
        int zero = -1; //[0, zero] 表示包含0的区间
        int two = nums.length; //[two, length-1] 表示包含2的区间
        //所以 [zero+1,i-1] 这个范围就是包含1的区间
        for(int i = 0; i < two; ){
            if( nums[i] == 1 )
                i++;
            else if( nums[i] == 0){
                zero++;
                swap(nums,i,zero);
                i++;
            }else{ // nums[i] == 2
                two --;
                swap(nums,i,two);
            }
        }
    }

    public void sortColors3(int[] nums){
        int zero = -1; //[0, zero] 表示包含0的区间
        int two = nums.length; //[two, length-1] 表示包含2的区间
        //所以 [zero+1,i-1] 这个范围就是包含1的区间,i就是当前未知元素
        for(int i = 0; i < two; ){ // 注意，不是： i < nums.length，它的范围是一个变量
            if( nums[i] == 1 )
                i++;
            else if( nums[i] == 2 ) //这时 i 并不往前移动
                swap(nums,i,--two);
            else // nums[i] == 0
                swap(nums,i++,++zero);
        }
    }

    public void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        _075SortColors s = new _075SortColors();
        int[] nums = {2,0,2,1,1,0,1};
        s.sortColors3(nums);
        for(int n : nums)
            System.out.print(n+",");
    }
}
