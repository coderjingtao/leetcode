package solutions;

import basic.BinaryTree;
import basic.TreeNode;
import basic.TreeUtil;

/**
 * NO.110 Balanced Binary Tree
 * Keywords:   Binary Tree
 * Difficulty: Easy
 * Company: bloomberg
 */
public class _110BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return isBalanced(root.left) && isBalanced(root.right) && isBalanced(root.left,root.right);
    }

    private boolean isBalanced(TreeNode node1, TreeNode node2){
        return Math.abs(height(node1) - height(node2)) <= 1 ;
    }

    private int height(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }

    public static void main(String[] args) {
        _110BalancedBinaryTree test = new _110BalancedBinaryTree();
        BinaryTree bt = new BinaryTree(new Integer[]{1,2,2,3,null,null,3,4,null,null,4});
        TreeUtil.show(bt.root);
        boolean ret = test.isBalanced(bt.root);
        System.out.println(ret);
    }
}
