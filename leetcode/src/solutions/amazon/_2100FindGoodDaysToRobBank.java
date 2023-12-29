package solutions.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * 2100 Find Good Days to Rob the Bank
 * Keywords:
 * Difficulty: Medium
 * Company: Amazon, Apple
 */
public class _2100FindGoodDaysToRobBank {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        int len = security.length;
        int[] dec = new int[len];//存储连续递减的天数
        int[] inc = new int[len];//存储连续递增的天数

        dec[0] = 0;
        for(int i = 1; i < len; i++){
            if(security[i-1] >= security[i]){
                dec[i] = dec[i-1] + 1;
            }else{
                dec[i] = 0;
            }
        }
        inc[len-1] = 0;
        for(int i = len-2; i >= 0; i--){
            if(security[i] <= security[i+1]){
                inc[i] = inc[i+1] + 1;
            }else{
                inc[i] = 0;
            }
        }
        //如果索引中对应的连续递增和递减的天数 >= time，则就是结果
        for(int i = time; i < len - time; i++){
            if(dec[i] >= time && inc[i] >= time){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _2100FindGoodDaysToRobBank s = new _2100FindGoodDaysToRobBank();
        int[] security = {1,1,1,1,1};
        int time = 0;
        List<Integer> res = s.goodDaysToRobBank(security, time);
        System.out.println("res = " + res);
    }


}
