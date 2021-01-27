package basic;

import java.util.Arrays;

/**
 * Description: Binary Search
 * Created by Jingtao Liu on 26/02/2019.
 */
public class BinarySearch {

    //1. while loop version
    public static int binarySearch(int[] arr, int target){
        int left=0, right =arr.length-1; //在[left, right]中寻找target,在循环中保证“循环不变量”

        while (left <= right){ //left = right时，区间[left,right]依然是有效的
            //int mid = (right+left)/2;
            int mid = left + (right - left)/2;
            if(target == arr[mid])
                return mid;
            else if(target < arr[mid])
                right = mid -1; // target在区间 [left, mid-1]
            else
                left = mid + 1; // target在区间 [mid+1, right]
        }
        return -1;
    }

    //2.recursive version
    public static int binarySearch2(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        return binarySearch(arr,left,right,target);
    }

    private static int binarySearch(int[] arr, int left, int right, int target){
        if(left > right || right < left)
            return -1;
        int mid = left + (right-left) / 2;
        if(arr[mid] == target)
            return mid;
        else if(arr[mid] > target)
            return binarySearch(arr,left,mid-1,target);
        else // arr[mid] < target
            return binarySearch(arr,mid+1,right,target);
    }

    //进阶
    /**
     * 二分查找法, 在有序数组arr中, 查找target
     * 如果找到target, 返回第一个target相应的索引index
     * 如果没有找到target, 返回比target小的最大值相应的索引, 如果这个最大值有多个, 返回最大索引
     * 如果这个target比整个数组的最小元素值还要小, 则不存在这个target的floor值, 返回-1
     */
    public static int floor(int[] arr, int target){
        int left = -1;
        int right = arr.length-1;
        while(left < right){
            int mid = left + (right - left + 1) / 2 ;// 使用向上取整避免死循环
            if(arr[mid] >= target)
                right = mid-1;
            else
                left = mid;
        }
        assert left == right;
        if(left+1 < arr.length && arr[left+1] == target) // 如果该索引+1就是target本身, 该索引+1即为返回值
            return left+1;

        return left; // 否则, 该索引即为返回值
    }

    /**
     * 二分查找法, 在有序数组arr中, 查找target
     * 如果找到target, 返回最后一个target相应的索引index
     * 如果没有找到target, 返回比target大的最小值相应的索引, 如果这个最小值有多个, 返回最小的索引
     * 如果这个target比整个数组的最大元素值还要大, 则不存在这个target的ceil值, 返回整个数组元素个数n
     */
    public static int ceil(int[] arr, int target){
        int left = 0;
        int right = arr.length;
        while(left < right){
            int mid = left + (right-left) / 2;// 使用普通的向下取整即可避免死循环
            if(arr[mid] <= target)
                left = mid+1;
            else
                right = mid;
        }
        assert left == right;
        if(right-left >= 0 && arr[right-1] == target)// 如果该索引-1就是target本身, 该索引+1即为返回值
            return right-1;
        return right;// 否则, 该索引即为返回值
    }


    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,9,10,11,12,13};
        System.out.println(binarySearch2(arr,0));
    }
}
