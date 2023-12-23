package solutions.amazon;

import java.util.Arrays;
import java.util.Comparator;

/**
 * NO.1710 Maximum Units on a Truck
 * Keywords:
 * Difficulty: Easy
 * Company: Amazon
 */
public class _1710MaximumUnitsOnTruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(x -> -x[1]));
        int res = 0;
        int left_size = truckSize;
        for(int[] boxType : boxTypes){
            if(left_size <= 0){
                break;
            }
            if(left_size - boxType[0] >= 0){
                res += boxType[0] * boxType[1];
                left_size = left_size - boxType[0];
            }else{
                res += left_size * boxType[1];
                left_size = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] box1 = {5,10};
        int[] box2 = {2,5};
        int[] box3 = {4,7};
        int[] box4 = {3,9};
        int[][] boxTypes = {box1,box2,box3,box4};
        _1710MaximumUnitsOnTruck solution = new _1710MaximumUnitsOnTruck();
        int res = solution.maximumUnits(boxTypes, 10);
        System.out.println("res = " + res);

        int[] box11 = {1,3};
        int[] box21 = {2,2};
        int[] box31 = {3,1};
        int[][] boxTypes2 = {box11,box21,box31};
        int res2 = solution.maximumUnits(boxTypes2, 4);
        System.out.println("res2 = " + res2);
    }
}
