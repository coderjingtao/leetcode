package solutions;

import datastructure.tree.BinaryTree;
import basic.TreeNode;
import basic.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * NO.113 Path Sum 2
 * Keywords:   Binary Tree
 * Difficulty: Medium
 * Company: Bloomberg
 */
public class _113PathSum2 {
    /**
     * 该题目是 #112 Path Sum 和 #257 Binary Tree Paths的结合体
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> paths = new ArrayList();
            List<Integer> path = new ArrayList<>();
            if(root == null)
                return paths;
            if(root.left == null && root.right == null && root.val == sum){//leaf node
                path.add(root.val);
                paths.add(path);
                return paths;
            }
            List<List<Integer>>  leftPaths = pathSum(root.left,sum-root.val);
            for(int i=0; i<leftPaths.size(); i++){
                List<Integer> oneLeftPath = leftPaths.get(i);
                oneLeftPath.add(0,root.val);
                paths.add(oneLeftPath);
            }

            List<List<Integer>>  rightPaths = pathSum(root.right,sum-root.val);
            for(int i=0; i<rightPaths.size(); i++){
                List<Integer> oneRightPath = rightPaths.get(i);
                oneRightPath.add(0,root.val);
                paths.add(oneRightPath);
            }

            return paths;
    }

    public static void main(String[] args) {
        _113PathSum2 test = new _113PathSum2();
        BinaryTree bt = new BinaryTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        TreeUtil.show(bt.root);
        List<List<Integer>> paths = test.pathSum(bt.root,22);
        for(List<Integer> onepath: paths)
            System.out.println(Arrays.toString(onepath.toArray()));
    }
}
