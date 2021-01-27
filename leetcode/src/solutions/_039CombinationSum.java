package solutions;

import java.util.*;

/**
 * NO.39 Combination Sum
 * Keywords:   combination, tree-shaped problem, backtracking, recursive
 * Difficulty: Medium
 * Company:    Snapchat, Uber
 */
public class _039CombinationSum {

    /**
     * Solution: backtracking
     * Time Complexity: O(n^n)
     * Space Complexity: O(target)
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return result;
        generateCombination(candidates,target,0,new ArrayList<>(), result);
        return result;
    }

    private void generateCombination(int[] candidates, int target, int start, List<Integer> comb, List<List<Integer>> combs){

        if( target == 0 ){ //recursive termination
            combs.add(new ArrayList<>(comb));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if( candidates[i] <= target ){
                comb.add(candidates[i]);
                generateCombination(candidates, target-candidates[i], i, comb, combs);
                comb.remove(comb.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        _039CombinationSum combination = new _039CombinationSum();
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> result = combination.combinationSum(candidates,target);
        for(List<Integer> c : result){
            System.out.print("[");
            for(Integer i : c)
                System.out.print(i+" ");
            System.out.print("]");
            System.out.println();
        }
    }
}
