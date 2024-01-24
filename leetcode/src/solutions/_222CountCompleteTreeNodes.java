package solutions;

import datastructure.tree.BinaryTree;
import basic.TreeNode;
import basic.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * NO.222 Count Complete Tree Nodes
 * Keywords:   Binary Tree
 * Difficulty: Medium
 * Company:
 */
public class _222CountCompleteTreeNodes {

    //Iteration 适合所有的二叉树
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            count++;
            if(node.left !=null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
        return count;
    }

    //Recursion 利用完全二叉树的特性
    public int countNodes2(TreeNode root) {
        if(root == null)
            return 0;
        return countNodes2(root.left) + 1 + countNodes2(root.right);
    }

    public static void main(String[] args) {
        _222CountCompleteTreeNodes test = new _222CountCompleteTreeNodes();
        BinaryTree one = new BinaryTree(new Integer[]{1, 2, 3,4,5,6});
        TreeUtil.show(one.root);
        int num = test.countNodes2(one.root);
        System.out.println(num);
    }
}
