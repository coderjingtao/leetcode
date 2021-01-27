package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. Number of Boomerangs
 * Keywords:   HashMap
 * Difficulty: Easy
 * Company:    Google
 */
public class _447NumberOfBoomerangs {
    /**
     * Question:找到3个点，使得第1点到剩下2点的距离相等，返回符合这个特性的所有3点的数量(需要考虑顺序)
     * Thought: 把每一个点都当作枢纽点，并建立一张查找表：查找剩余所有点到该枢纽距离的查找表，HashMap <distance: frequency>
     * 当frequency大于等于2的时候，说明存在大于等于2个点与该点的距离相等
     * 所有的可能性  += frequency * (frequency-1)  --> 考虑顺序的情况
     * 所有的可能性  += frequency * (frequency-1) / 2  --> 不考虑顺序的情况
     */
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for(int i = 0; i < points.length; i++){
            //每个点都建立一张查找表
            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            for(int j = 0; j < points.length; j++){
                if( j != i) { //point1=points[i]; point2=points[j];
                    int dist = distance(points[i],points[j]);
                    int freq = map.getOrDefault(dist, 0);
                    map.put(dist, freq+1);
                }
            }
            //查找
            for(int freq: map.values())
                if(freq >= 2) //这句可以省略，因为当频率为1时，根据公式它的可能性为0，不影响结果
                    res += freq * (freq-1);
        }
        return res;
    }

    // 2点距离公式：(x2-x1)^2 + (y2-y1)^2 再开方
    // 但开方会遇到小数的精度问题，因此省略开方，因为距离的平方相等时，距离一定相等
    private int distance(int[] point1, int[] point2){
        return (point2[0] - point1[0]) * (point2[0] - point1[0])
                + (point2[1] - point1[1]) * (point2[1] - point1[1]);
    }

    public static void main(String[] args) {
        int[][] points = { {0,0}, {1,0}, {-1,0}, {0,1}, {0,-1}};
        _447NumberOfBoomerangs n = new _447NumberOfBoomerangs();
        System.out.println(n.numberOfBoomerangs(points));
    }
}
