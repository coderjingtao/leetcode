package solutions;

import datastructure.tree.BinaryTree;
import basic.TreeNode;

/**
 * NO.100 Same Tree
 * Keywords:   Binary Tree
 * Difficulty: Easy
 * Company:    Bloomberg
 */
public class _100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        // p != null && q != null && p.val == q.val 这时根一定相同，往下比较子树
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        _100SameTree test = new _100SameTree();
        BinaryTree one = new BinaryTree(new Integer[]{1, 2, 1});
        BinaryTree two = new BinaryTree(new Integer[]{1, 1, 2});
        boolean ret = test.isSameTree(one.root, two.root);
        System.out.println(ret);
    }
}
