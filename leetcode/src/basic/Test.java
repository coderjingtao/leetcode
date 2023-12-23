package basic;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Description: ${Desc}
 * Created by Jingtao Liu on 3/01/2020.
 */
public class Test {

    public static void main(String[] args) {
        Set<Pair> set1 = new HashSet<>();
        set1.add(new Pair(0,0));
        set1.add(new Pair(1,1));
        set1.add(new Pair(2,2));

        Set<Pair> set2 = new HashSet<>();
        set2.add(new Pair(1,1));
        set2.add(new Pair(2,2));

        boolean contains = contains(set1, set2);
        System.out.println("set1 all contains set2= " + contains);

    }

    //set2中的元素全部被set1覆盖
    private static boolean contains(Set<Pair> set1, Set<Pair> set2){
        for(Pair pair : set2){
            if(!set1.contains(pair)){
                return false;
            }
        }
        return true;
    }
}

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
