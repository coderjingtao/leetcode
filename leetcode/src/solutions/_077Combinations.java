package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * NO.77 Combinations
 * Keywords:   combination, tree-shaped problem, backtracking, recursive
 * Difficulty: Medium
 * Company:
 */
public class _077Combinations {
    /**
     * Solution:
     * 本题是组合问题，不考虑元素的顺序
     * 采用的是树形回溯法:回溯法是暴力求解的一种手段
     *                     [1,2,3,4]中取2个数
     *                   /      |      |      \
     *                  取1     取2    取3     取4
     *                  /       |      |        \
     *     [2,3,4]中取1    [3,4]中取1  [4]中取1  []中取1
     *     /  |  \          /    \      |
     *     2  3   4        3      4     4
     * Time complexity: O(n^k)
     * Space complexity: O(k)
     */
    private List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result =  new ArrayList<>();
        if( n <= 0 || k <= 0 || k > n)
            return result;
        generateCombinations(n,k,1,new ArrayList<Integer>());
        return result;
    }

    /**
     * 求解C(n,k):把当前已经找到的组合存储在c中，之后需要从start开始搜索新的元素
     */
    private void generateCombinations(int n, int k, int start, List<Integer> comb){
        //递归终止条件
        if(comb.size() == k){
            result.add(new ArrayList<>(comb)); //需要值传递
            return;
        }
        //优化：for( int i = start; i <= n; i++)
        //to: i 最大是 n - (k - c.size()) + 1
        for( int i = start; i <= n - (k - comb.size()) + 1 ; i++){
            comb.add(i);// add Integer i
            generateCombinations(n,k,i+1,comb);//递归得到Integer i与i之后数字的所有组合
            comb.remove(comb.size()-1);//remove Integer i
        }
    }

    public static void main(String[] args) {
        _077Combinations com = new _077Combinations();
        List<List<Integer>> res = com.combine(4,2);
        for(List<Integer> c : res){
            System.out.print("[");
            for(Integer i : c)
                System.out.print(i+" ");
            System.out.print("]");
            System.out.println();
        }

    }
}
