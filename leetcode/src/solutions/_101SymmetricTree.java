package solutions;

import datastructure.tree.BinaryTree;
import basic.TreeNode;
import basic.TreeUtil;

/**
 * NO.101 Symmetric Tree
 * Keywords:   Binary Tree
 * Difficulty: Easy
 * Company:    Bloomberg, LinkedIn, Microsoft
 */
public class _101SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null)
            return true;
        if(node1 == null || node2 == null)
            return false;
        //必须同时满足下列3个条件，才是镜像
        return (node1.val == node2.val) && isMirror(node1.left,node2.right) && isMirror(node1.right,node2.left);
    }

    public static void main(String[] args) {
        _101SymmetricTree test = new _101SymmetricTree();
        BinaryTree bt = new BinaryTree(new Integer[]{1,2,2,null,3,null,3});
        TreeUtil.show(bt.root);
        boolean ret = test.isSymmetric(bt.root);
        System.out.println(ret);
    }
}
