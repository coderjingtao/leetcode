package solutions;

import basic.BinaryTree;
import basic.TreeNode;
import basic.TreeUtil;

/**
 * NO.404 Sum of Left Leaves
 * Keywords:   Binary Tree
 * Difficulty: Easy
 * Company: Facebook
 */
public class _404SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root){
        return helper(root,false);
    }

    private int helper(TreeNode node, boolean isFromLeft){
        if(node == null)
            return 0;
        if(node.left == null && node.right == null){//叶子节点
            return isFromLeft ? node.val : 0;
        }
        int sum = 0;
        if(node.left != null)
            sum += helper(node.left,true);
        if(node.right != null)
            sum += helper(node.right,false);
        return sum;
    }

    public static void main(String[] args) {
        _404SumOfLeftLeaves test = new _404SumOfLeftLeaves();
        BinaryTree bt = new BinaryTree(new Integer[]{3,9,20,null,null,15,7});
        TreeUtil.show(bt.root);
        int ret = test.sumOfLeftLeaves(bt.root);
        System.out.println(ret);
    }
}
