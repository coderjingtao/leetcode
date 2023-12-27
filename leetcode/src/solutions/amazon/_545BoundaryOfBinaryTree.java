package solutions.amazon;

import basic.TreeNode;
import basic.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 545 Boundary of Binary Tree
 * Keywords: Binary Tree
 * Difficulty: Medium
 * Company: Apple, Amazon
 */
public class _545BoundaryOfBinaryTree {

    List<Integer> res = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        res.add(root.val);
        leftBoundary(root.left);
        bottomBoundary(root.left);
        bottomBoundary(root.right);
        rightBoundary(root.right);
        return res;
    }

    private void leftBoundary(TreeNode root){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        res.add(root.val);
        if(root.left == null){
            leftBoundary(root.right);
        }else{
            leftBoundary(root.left);
        }
    }
    private void rightBoundary(TreeNode root){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        if(root.right == null){
            rightBoundary(root.left);
        }else{
            rightBoundary(root.right);
        }
        res.add(root.val);
    }
    //leaf nodes
    private void bottomBoundary(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            res.add(root.val);
            return;
        }
        bottomBoundary(root.left);
        bottomBoundary(root.right);
    }

    public static void main(String[] args) {
        _545BoundaryOfBinaryTree s = new _545BoundaryOfBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeUtil.show(root);
        List<Integer> res = s.boundaryOfBinaryTree(root);
        System.out.println("res = " + res);
    }
}
