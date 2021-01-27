package solutions;

import basic.TreeNode;

/**
 * NO.104 Maximum Depth of Binary Tree
 * Keywords:   Binary Tree
 * Difficulty: Easy
 * Company:    LinkedIn, Uber, Yahoo, Apple
 */
public class _104MaximumDepthOfBinaryTree {

    /**
     * 充分利用二叉树的天然递归性
     */
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

}
