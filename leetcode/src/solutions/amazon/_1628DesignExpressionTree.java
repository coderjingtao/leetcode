package solutions.amazon;

import java.util.Stack;
import java.util.function.BiFunction;

/**
 * NO.1628 Design an Expression Tree With Evaluate Function
 * Keywords: stack, oop
 * Difficulty: Medium
 * Company: Amazon
 */
public class _1628DesignExpressionTree {
    public static void main(String[] args) {
        String[] postfix = {"3","4","+","2","*","7","/"};
        TreeBuilder treeBuilder = new TreeBuilder();
        Node node = treeBuilder.buildTree(postfix);
        System.out.println(node.evaluate());
    }
}

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};
class NumberNode extends Node{
    int val;
    NumberNode(String val){
        this.val = Integer.parseInt(val);
    }
    @Override
    public int evaluate() {
        return this.val;
    }
}
class OperatorNode extends Node{
    String operator;
    Node left, right;
    OperatorNode(String operator,Node left,Node right){
        this.operator = operator;
        this.left = left;
        this.right = right;
    }
    private BiFunction<Integer, Integer, Integer> op(String operator){
        switch (operator) {
            case "+" : return (a, b) -> a + b;
            case "-" : return (a, b) -> a - b;
            case "*" : return (a, b) -> a * b;
            case "/" : return (a, b) -> a / b;
            default: throw new RuntimeException();
        }
    }
    @Override
    public int evaluate() {
        return op(this.operator).apply(left.evaluate(), right.evaluate());
    }
}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<Node> stack = new Stack<>();
        for(String token : postfix){
            if(Character.isDigit(token.charAt(0))){
                stack.push(new NumberNode(token));
            }else{
                Node right = stack.pop();
                Node left = stack.pop();
                OperatorNode operatorNode = new OperatorNode(token,left,right);
                stack.push(operatorNode);
            }
        }
        return stack.pop();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
