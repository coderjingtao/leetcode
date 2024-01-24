package basic;

import datastructure.tree.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: ${Desc}
 * Created by Jingtao Liu on 3/01/2020.
 */
public class Test {
    private static int sum(int number){
        if(number == 1){
            return 1;
        }
        return number + sum(number-1);
    }
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{0,null,1,null,2,null,3,4};
        TreeNode root = TreeUtil.buildLeetCodeBinaryTree(nodes);
        TreeUtil.show(root);

        BinaryTree bt = new BinaryTree(new int[]{1,2,3,4,5,6,7,8,9,10});
        TreeUtil.show(bt.root);
    }

    public static int getMinimumFruits(List<Integer> fruits){
        Map<Integer,Integer> map = new HashMap<>();
        for(int fruit : fruits){
            map.put(fruit,map.getOrDefault(fruit,0)+1);
            if(map.size() == 2){
                for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                    map.put(entry.getKey(), entry.getValue()-1);
                }
            }
            List<Integer> removeKeyList = new ArrayList<>();
            for(int key : map.keySet()){
                if(map.get(key) == 0){
                    removeKeyList.add(key);
                }
            }
            for(int key : removeKeyList){
                map.remove(key);
            }
        }
        return map.size();
    }

    private int maxSubstring(String review, List<String> prohibitedWords){
        return 0;
    }




}
