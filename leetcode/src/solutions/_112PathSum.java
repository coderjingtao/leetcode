package solutions;

import basic.TreeNode;

/**
 * NO.112 Path Sum
 * Keywords:   Binary Tree
 * Difficulty: Easy
 * Company: Microsoft
 */
public class _112PathSum {

    //Recursion
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null) //判断root是否为叶子节点
            return root.val == sum;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}
