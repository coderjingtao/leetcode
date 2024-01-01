package solutions.amazon.spring2023;

import basic.TreeNode;

/**
 * NO.1676 Lowest Common Ancestor of a Binary Tree 4
 * Keywords:   Binary Tree, LCA, classic
 * Difficulty: Medium
 * Company: Amazon
 */
public class _1676LowestCommonAncestorOfBinaryTree4 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if(root == null){
            return null;
        }
        for(TreeNode node : nodes){
            if(root == node){
                return root;
            }
        }
        TreeNode left_lca = lowestCommonAncestor(root.left, nodes);
        TreeNode right_lca = lowestCommonAncestor(root.right, nodes);
        if(left_lca == null){
            return right_lca;
        }
        if(right_lca == null){
            return left_lca;
        }
        return root;
    }
}
