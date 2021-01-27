package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * NO.279 Perfect Squares
 * Keywords:   Queue BFS Graph shortest path
 * Difficulty: Medium
 * Company:    Google
 * Correlation: NO.127
 * todo: need to finish solutions : Memory Search and Dynamic Programming
 */
public class _279PerfectSquares {
    /**
     * Solution 1: BFS:无权图的最短路径
     * 任何一个正整数，都可以表示成若干个正整数的完全平方和，所以这道题一定有解：3 = 1*1 + 1*1 + 1*1
     *
     * 问题建模：
     * 从给定的正整数n到0，每个数字表示一个无权图的节点，如果两个数字之间正好相差一个完全平方数，则连接一条边，这样就得到了一个无权图
     * 问题转化为：求这个无权图中n节点到0节点的最短路径
     *  拿6举例：
     *  6--> 5 --> 4
     *  |    |   / |
     *  |    | /   |
     *  |    |3    |
     *  |   /|     |
     *  | /  |     |
     *  2 -->1 --> 0
     */
    public int numSquares(int n) {
        //pair(num,step),num表示节点数字，step表示经过多少步到达该数字
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(n,0));
        while( !queue.isEmpty() ){
            Pair<Integer,Integer> pair = queue.remove();
            int num = pair.key;
            int step = pair.value;
            if(num == 0)
                return step;
            for(int i=1; num-i*i >=0; i++)//以6为例，循环会把5和2放入栈，如果这个数字足够大，这时栈内会存在大量的重复pair，内存会马上吃光
                queue.add(new Pair<>(num-i*i,step+1));
        }
        return 0;
    }

    /**
     * Improve solution 1: BFS
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    public int numSquares2(int n) {
        //pair(num,step),num表示节点数字，step表示经过多少步到达该数字
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(n,0));
        //记录节点是否被访问到，如果访问到，则不再压入栈，避免大量内存占用
        boolean[] visited = new boolean[n+1];//开辟索引从0-n的大小为n+1的数组，默认值全部为false
        visited[n] = true;
        while( !queue.isEmpty() ){
            Pair<Integer,Integer> pair = queue.remove();
            int num = pair.key;
            int step = pair.value;
            for(int i=1;  ; i++){ //循环会把与num相邻的节点（相差一个完全平方数的数）全部压入栈
                int a = num - i*i ;
                if(a < 0)
                    break;
                if(a == 0)
                    return step+1;
                if(!visited[a]){
                    queue.add(new Pair<>(a,step+1));
                    visited[a]=true;
                }
            }
        }
        return 0;
    }

    private class Pair<K, V>{
        public K key;
        public V value;
        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        _279PerfectSquares p = new _279PerfectSquares();
        System.out.println(p.numSquares2(13));
    }
}
