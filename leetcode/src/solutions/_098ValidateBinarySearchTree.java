package solutions;

import datastructure.tree.BinaryTree;
import basic.TreeNode;
import basic.TreeUtil;

/**
 * NO.98 Validate Binary Search Tree
 * Keywords:   Binary Search Tree, BST
 * Difficulty: Medium
 * Company: Facebook, Microsoft, Amazon, Bloomberg
 */
public class _098ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null && root.right== null)
            return true;
        if(root.left != null && (root.left.val >= root.val || maximum(root.left) >= root.val) )
            return false;
        if(root.right != null && (root.right.val <= root.val || minimum(root.right) <= root.val) )
            return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private int minimum(TreeNode node){
        if(node.left == null)
            return node.val;
        return minimum(node.left);
    }

    private int maximum(TreeNode node){
        if(node.right == null)
            return node.val;
        return maximum(node.right);
    }


    public static void main(String[] args) {
        _098ValidateBinarySearchTree test = new _098ValidateBinarySearchTree();
        BinaryTree bt = new BinaryTree(new Integer[]{10,5,15,null,null,6,20});
        TreeUtil.show(bt.root);
        boolean ret = test.isValidBST(bt.root);
        System.out.println(ret);
    }
}
