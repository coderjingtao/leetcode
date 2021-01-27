package solutions;

import basic.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * NO.94 Binary Tree Inorder Traversal
 * Keywords:   Stack Recursive
 * Difficulty: Medium
 * Company:    Microsoft
 * Related:    NO.144 - Preorder, NO.145 - Postorder
 */
public class _094BinaryTreeInorderTraversal {

    /**
     * Solution 1: Recursive
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }

    private void inorder(TreeNode node, List<Integer> res){
        if(node != null){
            inorder(node.left, res);
            res.add(node.val);
            inorder(node.right, res);
        }
    }

    /**
     * Solution 2: System Command Stack to simulate recursive
     * Rationale refers to NO.144
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<Command> stack = new Stack<>();
        if(root == null)
            return res;
        stack.push(new Command("visit",root));
        while(!stack.isEmpty()){
            Command c = stack.pop();
            if(c.s.equals("print")){
                res.add(c.node.val);
            }else{//c.s.equals("visit")
                if(c.node.right != null)
                    stack.push(new Command("visit",c.node.right));
                stack.push(new Command("print",c.node));
                if(c.node.left != null)
                    stack.push(new Command("visit",c.node.left));
            }
        }
        return res;
    }

    //test
    public static void main(String[] args) {
        Integer[] input = {1,null,2,3};
        TreeNode root = new TreeNode(1);
        TreeNode x = new TreeNode(2);
        TreeNode y = new TreeNode(3);
        root.right = x;
        x.left = y;

        _094BinaryTreeInorderTraversal b = new _094BinaryTreeInorderTraversal();
        List<Integer> list = b.inorderTraversal2(root);
        System.out.println(list.toString());
    }
}
