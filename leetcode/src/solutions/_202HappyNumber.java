package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * NO.202 Happy Number
 * Keywords:   HashSet, recursive
 * Difficulty: Easy
 * Company:    Uber, Airbnb
 */
public class _202HappyNumber {
    //Idea:
    //用set记录中间的计算过程值，一旦发现有一样的计算值，说明会发生循环计算，这个数字则不是happy number
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<Integer>();
        record.add(n);
        while(n != 1){
            n = squareSum(n);
            if( record.contains(n))
                return false;
            else
                record.add(n);
        }
        return true;
    }

    private int squareSum(int n){
        int sum=0;
        while(n != 0){
            int m = n%10; //取出个位数字
            sum += m*m;
            n = n/10; //右移一位，即去掉个位数字
        }
        return sum;
    }

    public static void main(String[] args) {
        _202HappyNumber h = new _202HappyNumber();
        System.out.println(h.isHappy(81));
    }
}
