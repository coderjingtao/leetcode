package basic;

import java.util.TreeMap;

/**
 * Description: ${Desc}
 * Created by Jingtao Liu on 3/01/2020.
 */
public class Test {

    public static void main(String[] args) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(3,0);
        map.put(6,1);
        map.put(12,2);
        map.put(15,3);
        map.put(16,4);
        map.put(19,5);

        Integer ceilingKey = map.ceilingKey(3);
        System.out.println("ceilingKey = " + ceilingKey);

        Integer floorKey = map.floorKey(16);
        System.out.println("floorKey = " + floorKey);
    }

    private static int sum(int number){
        if(number == 1){
            return 1;
        }
        return number + sum(number-1);
    }
}
