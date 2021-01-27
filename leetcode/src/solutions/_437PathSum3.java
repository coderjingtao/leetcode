package solutions;

import basic.BinaryTree;
import basic.TreeNode;
import basic.TreeUtil;

/**
 * NO.437 Path Sum 3
 * Keywords:   Binary Tree
 * Difficulty: Easy
 * Company:
 */
public class _437PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return dfs(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }
    //找到以node为起点，和为sum的所有路径的总数
    private int dfs(TreeNode node, int sum){
        int res = 0;
        if(node == null)
            return res;
        if(node.val == sum){
            //由于node存在负数,可能存在sum ==5 当前节点为 5 -> -3 -> 3
            //这种情况，所以不能返回继续向下走,直到节点为空
            res += 1;
        }
        res += dfs(node.left,sum-node.val);
        res += dfs(node.right,sum-node.val);
        return res;
    }

    public static void main(String[] args) {
        _437PathSum3 test = new _437PathSum3();
        BinaryTree bt = new BinaryTree(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        TreeUtil.show(bt.root);
        int ret = test.pathSum(bt.root,8);
        System.out.println(ret);
    }
}
