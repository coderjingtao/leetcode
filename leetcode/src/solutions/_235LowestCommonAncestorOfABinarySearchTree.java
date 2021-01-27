package solutions;

import basic.BinaryTree;
import basic.TreeNode;
import basic.TreeUtil;

/**
 * NO.235 Lowest Common Ancestor of a Binary Search Tree
 * Keywords:   Binary Search Tree, BST, LCA, classic
 * Difficulty: Easy
 * Company: Facebook, Microsoft, Amazon, Twitter
 */
public class _235LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left,p,q);
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right,p,q);
        return root; // p <= root <= q
    }

    public static void main(String[] args) {
        _235LowestCommonAncestorOfABinarySearchTree test = new _235LowestCommonAncestorOfABinarySearchTree();
        BinaryTree bt = new BinaryTree(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
        TreeUtil.show(bt.root);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        TreeNode ret = test.lowestCommonAncestor(bt.root,p,q);
        System.out.println(ret.val);
    }
}
