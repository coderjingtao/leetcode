package solutions;

import basic.BinaryTree;
import basic.TreeNode;
import basic.TreeUtil;
/**
 * NO.1022 Sum of Root To Leaf Binary Numbers
 * Keywords:   Binary Tree
 * Difficulty: Easy
 * Company:
 */
public class _1022SumOfRootToLeafBinaryNumbers {

    public int sumRootToLeaf(TreeNode root) {
        return dfs_sum(root,0);
    }

    /**
     * 寻找以node为根的所有根到叶子路径的和
     * 状态转移方程： node: 当前节点, parentVal: node的父节点值
     * f(node,parentVal) =
     *      f(node.left, 2*parentVal + node.val)  left节点以及left节点的父节点值
     *    + f(node.right, 2*parentVal+ node.val)  right节点以及right节点的父节点值
     */
    private int dfs_sum(TreeNode node,int parentVal){
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return 2*parentVal + node.val;
        return dfs_sum(node.left,2*parentVal + node.val) + dfs_sum(node.right,2*parentVal + node.val);
    }

    public static void main(String[] args) {
        _1022SumOfRootToLeafBinaryNumbers test = new _1022SumOfRootToLeafBinaryNumbers();
        BinaryTree bt = new BinaryTree(new Integer[]{1,0,1,0,1,0,1});
        TreeUtil.show(bt.root);
        int ret = test.sumRootToLeaf(bt.root);
        System.out.println(ret);
    }
}
