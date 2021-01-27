package basic;

/**
 * Description: 最大公约数 Greatest Common Divisor
 * Created by Jingtao Liu on 1/03/2019.
 */
public class GCD {

    public int generalizedGCD(int num, int[] arr)
    {
        int x = arr[0];
        for(int i=1; i< num; i++){
            int y = arr[i];
            x = gcd(x,y);
        }
        return x;
    }

    /**
     * 欧几里得算法（Euclidean algorithm）
     * 两个正整数a和b（a>b），它们的最大公约数等于a除以b的余数c和b之间的最大公约数。
     * 比如10和25，25除以10商2余5，那么10和25的最大公约数，等同于10和5的最大公约数
     */
    private int gcd(int num1, int num2){
        while(num1 * num2 > 0){ //当其中一个为0时，终止循环
            if(num1 > num2){
                num1 = num1%num2;
            }else if(num1 < num2){
                num2 = num2%num1;
            }
        }
        return num1 > num2 ? num1 : num2;
    }

    public static void main(String[] args) {
        GCD g =  new GCD();
        int[] arr = {2,4,6,8,10};
        int num =5;
        System.out.println(g.generalizedGCD(num,arr));
    }
}
