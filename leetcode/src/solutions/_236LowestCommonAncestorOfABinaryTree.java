package solutions;

import basic.BinaryTree;
import basic.TreeNode;
import basic.TreeUtil;

/**
 * NO.236 Lowest Common Ancestor of a Binary Tree
 * Keywords:   Binary Tree, LCA, classic
 * Difficulty: Medium
 * Company: Facebook, Microsoft, Amazon, LinkedIn, Apple
 */
public class _236LowestCommonAncestorOfABinaryTree {

    /* Note:
        All of the nodes' values will be unique.
        p and q are different and both values will exist in the binary tree.
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root.val == p.val || root.val == q.val)
            return root;
        /**
         * 递归：
         * 当左子树或右子树中只存在一个节点p或q时, 返回的是p或q本身
         * 这是由递归终止条件决定的，例如，传入的子节点为6，当遍历到以6为根的子树时，满足递归终止条件，返回6
         * 所以当左右LCA返回值都不为空时，p和q一定是在root的两侧
         */
        TreeNode left_LCA = lowestCommonAncestor(root.left,p,q);
        TreeNode right_LCA = lowestCommonAncestor(root.right,p,q);
        if(left_LCA != null && right_LCA != null) //两者都不为空，表示p和q分别在root的两侧，则root一定是LCA
            return root;
        if(left_LCA != null)
            return left_LCA;
        if(right_LCA != null)
            return right_LCA;
        return null;
    }
    //更优雅的写法
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val)
            return root;
        TreeNode left_LCA = lowestCommonAncestor(root.left,p,q);
        TreeNode right_LCA = lowestCommonAncestor(root.right,p,q);
        if(left_LCA == null)
            return right_LCA;
        if(right_LCA == null)
            return left_LCA;
        return root;
    }

    public static void main(String[] args) {
        _236LowestCommonAncestorOfABinaryTree test = new _236LowestCommonAncestorOfABinaryTree();
        BinaryTree bt = new BinaryTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeUtil.show(bt.root);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        TreeNode ret = test.lowestCommonAncestor(bt.root,p,q);
        System.out.println(ret.val);
    }
}
