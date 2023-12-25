package basic;

/**
 * Description: ${Desc}
 * Created by Jingtao Liu on 3/01/2020.
 */
public class Test {

    public static void main(String[] args) {
        int sum = sum(100);
        System.out.println(sum);
    }

    private static int sum(int number){
        if(number == 1){
            return 1;
        }
        return number + sum(number-1);
    }
}
