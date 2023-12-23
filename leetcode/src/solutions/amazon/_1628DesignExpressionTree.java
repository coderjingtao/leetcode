package solutions.amazon;

import basic.TreeNode;
import basic.TreeUtil;

/**
 * NO.1628 Design an Expression Tree With Evaluate Function
 * Keywords:
 * Difficulty: Medium
 * Company: Amazon
 */
public class _1628DesignExpressionTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(7);
        root.left = new TreeNode(8);
        TreeUtil.show(root);
    }
}

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
    protected String val;
    protected Node left;
    protected Node right;
    public Node(String val){
        this.val = val;
    }
};
class MyNode extends Node{

    public MyNode(String val) {
        super(val);
    }

    @Override
    public int evaluate() {
        return 0;
    }
}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    //Node buildTree(String[] postfix) {
    //
    //}
    ////postOrder = left subtree | right subtree | root
    //MyNode dfs(String[] postOrder){
    //    int index = 0;
    //    for(int i = 0; i < postOrder.length; i++){
    //        if(postOrder[i].equals("+") || postOrder[i].equals("-") || postOrder[i].equals("*") || postOrder[i].equals("/")){
    //            index = i;
    //            break;
    //        }
    //    }
    //    MyNode root = new MyNode(postOrder[index]);
    //    root.left = new MyNode(postOrder[index-2]);
    //    root.right = new MyNode(postOrder[index-1]);
    //}
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
