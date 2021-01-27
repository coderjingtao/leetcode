package basic;

import java.util.*;

/**
 * Description: Array Sorting by ascend and descend
 * Created by Jingtao Liu on 6/03/2019.
 */
public class ArraySort {
    //1. 用Arrays.sort实现int[]升序：
    public static int[] ascendingSort(int[] arr){
        Arrays.sort(arr);
        return arr;
    }
    //2. 用Arrays.sort实现int[]降序：
    //降序排序，不能使用基本类型:int,double,char，boolean, 需要转化成对应的包装类型wrapper class
    public static Integer[] descendingSort(int[] arr){
        Integer[] integerArray = toIntegerArray(arr);
        Arrays.sort(integerArray, Collections.reverseOrder());
        return integerArray;
    }

    private static Integer[] toIntegerArray(int[] arr){
        Integer[] newArr = new Integer[arr.length];
        for(int i=0; i < arr.length; i++)
            newArr[i] = arr[i];
        return newArr;
    }

    //3.用Arrays.sort和自定义比较器Comparator实现int[]降序
    public static Integer[] descendingSort2(int[] arr){
        Integer[] integerArray = toIntegerArray(arr);
        Comparator<Integer> cmp = new MyComparator();
        Arrays.sort(integerArray, cmp);
        return integerArray;
    }

    //4.用Collections.sort实现int[]升序：
    public static Integer[] ascendingSort2(int[] arr){
        Integer[] integerArray = toIntegerArray(arr);
        List<Integer> list = Arrays.asList(integerArray);
        Collections.sort(list);
        return list.toArray(new Integer[list.size()]);
    }

    //4.用Collections.sort实现int[]降序：
    public static Integer[] descendingSort3(int[] arr){
        Integer[] integerArray = toIntegerArray(arr);
//        List<Integer> list = Arrays.asList(integerArray);//返回的list是固定大小的，不能添加或删除元素，程序会抛出异常UnsupportedOperationException
        List<Integer> list = new ArrayList<>(Arrays.asList(integerArray));//返回的list是正常的ArrayList
        Collections.sort(list,Collections.reverseOrder());
        return list.toArray(new Integer[list.size()]);
    }


    //test
    public static void main(String[] args) {
        int[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
        System.out.println(Arrays.toString(descendingSort3(a)));
    }
}

 class MyComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 > o2){
            return -1;
        }else if(o1 < o2){
            return 1;
        }else{
            return 0;
        }
    }
}


