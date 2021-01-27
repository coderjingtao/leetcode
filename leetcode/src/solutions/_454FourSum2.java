package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * NO.454 Four Sum II
 * Keywords:   HashMap
 * Difficulty: Medium
 * Company:
 */
public class _454FourSum2 {
    /**
     * Idea:
     * 降维：将4维利用查找表降维到2维+2维，即用空间换时间
     * 1.将C+D的每一种可能都放入查找表：O(n^2)
     *   由于C+D之和可能重复，所以不能用set，应该用map:<C+D: frequency>,即存储C+D之和所对应的出现的可能性有多少
     * 2.遍历A和B,并去查找表查找 0-sum(A+B)是否在查找表key中，如果有，则表示A+B+C+D=0成立，map的值则是成立的次数
     * 时间复杂度：O(n^2)+O(n^2)
     * 空间复杂度：O(n^2)
     * 它可以解决这四个数组个数不相等的情况（但题目给定每个数组的长度都相等）
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < C.length; i++)
            for(int j = 0; j < D.length; j++){
                int freq =  map.getOrDefault(C[i]+D[j], 0);
                map.put(C[i]+D[j], freq+1);
            }

        int res = 0;
        for(int i = 0; i < A.length; i++)
            for(int j=0; j < B.length; j++)
                if(map.containsKey(-A[i]-B[j]))
                    res += map.get(-A[i]-B[j]);

        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        _454FourSum2 f = new _454FourSum2();
        System.out.println(f.fourSumCount(A, B, C, D));
    }
}
