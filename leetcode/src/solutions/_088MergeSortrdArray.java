package solutions;

/**
 * NO.88 Merge Sorted Array
 * Keywords:   Array, two pointer
 * Difficulty: Easy
 * Company:    Bloomberg
 */
public class _088MergeSortrdArray {

    //把nums1和nums2顺序合并到新开辟的内存空间merge中，用于理解原理
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merge = new int[m+n];
        int i = 0 , j = 0;
        for( int index = 0; index < merge.length; index++ ){
            if(i > m-1){
                merge[index] = nums2[j];
                j++;
            }
            else if(j > n-1){
                merge[index] = nums1[i];
                i++;
            }
            else if(nums1[i] <= nums2[j] ){
                merge[index] = nums1[i];
                i++;
            }
            else if(nums1[i] > nums2[j]){
                merge[index] = nums2[j];
                j++;
            }
        }
        printArray(merge);
    }

    /**
     * 如果正序比较大小，则必须开辟新的空间
     * 新的思路是：把两个数组逆序比较大小，把较大的数放到新的合并后的数组的最后一位
     * 但需要判断可能nums2或nums1已经把所有元素都遍历完成的情况
     * 遍历完成后，则依次把另一个数组中的元素放到新合并的数组中即可
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p = m+n-1; //[0 ... m+n-1] 新的合并后的数组序列索引范围
        m = m-1;//[0,m-1] nums1中的元素索引范围
        n = n-1;//[0,n-1] nums2中的元素索引范围
        for(int i=p; i>=0; i--){
            if(m < 0) //nums1 中的元素逆序遍历完了
            {
                nums1[i] = nums2[n]; //把nums2中的元素依次逆序放到新数组中即可
                n--;
            }
            else if(n < 0) //nums2中的元素逆序遍历完了
            {
                nums1[i] = nums1[m];//把nums1中的元素依次逆序放到新数组中即可
                m--;
            }
            else if(nums1[m] > nums2[n]){ //逆序比较，把nums1和nums2中较大的元素放到新数组中，索引相应的要前移
                nums1[i] = nums1[m];
                m--;
            }
            else // nums1[m] <= nums2[n] 逆序比较，把nums1和nums2中较大的元素放到新数组中，索引相应的要前移
            {
                nums1[i] = nums2[n];
                n--;
            }
        }
    }

    //逆序：利用nums1空间足够的特点，依次把比较的大数放到末尾
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        //[0,m+n-1]
        int p = m-- + n-- -1 ;
        while(m>=0 && n>=0)
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--]:nums2[n--]; //执行到冒号前则m--,n保持不变，反之亦然
        while(n >= 0){ //可能m率先小于0，所以确保nums2中的全部元素n都插入到nums1中即可
            nums1[p--] = nums2[n--];
        }
    }

    public void printArray(int[] nums){
        for(int e: nums)
            System.out.print(e+",");
        System.out.println();
    }

    public int[] copyArray(int[] nums){
        int size = nums.length;
        int[] copy = new int[size];
        for(int i=0; i<size; i++)
            copy[i] = nums[i];
        return copy;
    }

    public static void main(String[] args) {
        _088MergeSortrdArray s = new _088MergeSortrdArray();
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        s.merge2(nums1, m, nums2, n);
        s.printArray(nums1);
    }
}
