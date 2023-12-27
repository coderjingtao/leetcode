package solutions.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * 1291 Sequential Digits
 * Keywords:
 * Difficulty: Medium
 * Company: Amazon
 */
public class _1291SequentialDigits {

    private final String digits = "123456789";

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for(int step = String.valueOf(low).length(); step <= String.valueOf(high).length(); step++){
            int i = 0;
            int j = i + step;
            while(j <= digits.length()){
                int d = Integer.parseInt(digits.substring(i, j));
                if(d >= low && d <= high){
                    res.add(d);
                }
                if(d > high){
                    break;
                }
                i++;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int low = 58;
        int high = 155;
        _1291SequentialDigits s = new _1291SequentialDigits();
        List<Integer> res = s.sequentialDigits(low, high);
        System.out.println("res = " + res);
    }
}
