package solutions;

import basic.TreeNode;

/**
 * NO.111 Minimum Depth of Binary Tree
 * Keywords:   Binary Tree
 * Difficulty: Easy
 * Company:
 */
public class _111MinimumDepthOfBinaryTree {

    /**
     * 题目要求：计算从根节点到叶子节点的最短路径，叶子节点意味着没有左子树也没有右子树
     * 注意：和104题不一样，所以终止条件有个小陷阱
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return 1 + minDepth(root.right);
        if (root.right == null)
            return 1 + minDepth(root.left);
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

}
