package solutions;

import basic.TreeNode;

/**
 * NO.226 Invert Binary Tree
 * Keywords:   Binary Tree
 * Difficulty: Easy
 * Company:    Google
 */
public class _226InvertBinaryTree {

    /**
     *  思路：先把以左右子树为根节点进行反转，再把左右子树以root为根进行反转
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
