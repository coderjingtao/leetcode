package solutions;

import datastructure.tree.BinaryTree;
import basic.TreeNode;
import basic.TreeUtil;

/**
 * NO.965 Univalued Binary Tree
 * Keywords:   Binary Tree
 * Difficulty: Easy
 * Company:
 */
public class _965UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if(root == null)
            return true;
        if(root.left != null && root.val != root.left.val)
            return false;
        if(root.right != null && root.val != root.right.val)
            return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public static void main(String[] args) {
        _965UnivaluedBinaryTree test = new _965UnivaluedBinaryTree();
        BinaryTree bt = new BinaryTree(new Integer[]{2,2,2,5,2});
        TreeUtil.show(bt.root);
        System.out.println(test.isUnivalTree(bt.root));
    }
}
