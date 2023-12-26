package solutions.amazon;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 2055 Plates Between Candles
 * Keywords: Directed Graph, Topological Sorting
 * Difficulty: Medium
 * Company: Amazon
 */
public class _2055PlatesBetweenCandles {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        TreeMap<Integer, Integer> candleMap = getCandleMap(s);
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            res[i] = getPlates(candleMap,queries[i][0],queries[i][1]);
        }
        return res;
    }

    /**
     * 通过字符串s,构建一个字符串s中candle的TreeMap
     * key ：candle在s中的索引位置
     * value ：candle的序列号，即是第几个candle
     * 使用TreeMap是因为可以使用它的map.ceilingKey()和map.floorKey()方法
     * @param s
     * @return Candle TreeMap
     */
    private TreeMap<Integer,Integer> getCandleMap(String s){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int candleSeq = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '|'){
                map.put(i,candleSeq++);
            }
        }
        return map;
    }

    private int getPlates(TreeMap<Integer,Integer> candleMap, int queryLeft, int queryRight){
        //get a key that >= queryLeft in candleMap
        Integer candleLeft = candleMap.ceilingKey(queryLeft);
        //get a key that <= queryRight in candleMap
        Integer candleRight = candleMap.floorKey(queryRight);
        if(candleLeft == null || candleRight == null || candleLeft >= candleRight){
            return 0;
        }
        Integer candleLeftSeq = candleMap.get(candleLeft);
        Integer candleRightSeq = candleMap.get(candleRight);
        return candleRight - candleLeft - (candleRightSeq - candleLeftSeq);
    }

    public static void main(String[] args) {
        String s = "***|**|*****|**||**|*";
        int[][] queries = {
                {1,17},
                {4,5},
                {14,17},
                {5,11},
                {15,16},
        };
        _2055PlatesBetweenCandles solution = new _2055PlatesBetweenCandles();
        int[] res = solution.platesBetweenCandles(s, queries);
        System.out.println("res = " + Arrays.toString(res));
    }
}
