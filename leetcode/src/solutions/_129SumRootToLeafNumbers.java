package solutions;

import datastructure.tree.BinaryTree;
import basic.TreeNode;
import basic.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * NO.129 Sum Root to Leaf Numbers
 * Keywords:   Binary Tree
 * Difficulty: Medium
 * Company:
 */
public class _129SumRootToLeafNumbers {

    //该题目是 NO.257 Binary Tree Paths 的变形题
    public int sumNumbers(TreeNode root) {
//        List<String> paths = path(root);
//        return paths.stream().map(num -> Integer.valueOf(num)).reduce(0,Integer::sum);
        return sum(root,0);
    }

    private List<String> path(TreeNode root){
        List<String> paths = new ArrayList<>();
        if(root == null)
            return paths;
        if(root.left == null && root.right==null){
            paths.add(Integer.toString(root.val));
            return paths;
        }
        List<String> leftPaths = path(root.left);
        for(String oneLeftPath : leftPaths){
            paths.add(root.val+""+oneLeftPath);
        }
        List<String> rightPaths = path(root.right);
        for(String oneRightPath: rightPaths){
            paths.add(root.val+""+oneRightPath);
        }
        return paths;
    }

    /**
     * Improved recursion
     * 状态转移方程 f(root, rootParentVal) = f(root.left, rootParentVal*10 + root.val) + f(root.right, rootParentVal*10 + root.val)
     */
    private int sum(TreeNode root, int parentVal){
        if(root == null)//当root为空时，他的和一定是0
            return 0;
        if(root.left == null && root.right == null)//leaf node
            return parentVal*10 + root.val;
        return sum(root.left,parentVal*10 + root.val) + sum(root.right,parentVal*10 + root.val);
    }

    public static void main(String[] args) {
        _129SumRootToLeafNumbers test = new _129SumRootToLeafNumbers();
        BinaryTree bt = new BinaryTree(new int[]{4,9,0,5,1});
        TreeUtil.show(bt.root);
        int total = test.sumNumbers(bt.root);
        System.out.println(total);
    }
}
