package basic;

/**
 * Description: ${Desc}
 * Created by Jingtao Liu on 3/01/2020.
 */
public class Test {
    private static int sum(int number){
        if(number == 1){
            return 1;
        }
        return number + sum(number-1);
    }
    public static void main(String[] args) {
        String[] strs = {
                "eat","tea","tan","ate","nat","bat"
        };

    }




}
