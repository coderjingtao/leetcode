package solutions;

import basic.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * NO.144 Binary Tree Postorder Traversal
 * Keywords:   Stack Recursive
 * Difficulty: Hard
 * Company:    Microsoft
 * Related:    NO.94 - Inorder, NO.144 - Preorder
 */
public class _145BinaryTreePostorderTraversal {

    /**
     * Solution 1: Recursive
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root,res);
        return res;
    }
    private void postorder(TreeNode node, List<Integer> res){
        if(node != null){
            postorder(node.left,res);
            postorder(node.right,res);
            res.add(node.val);
        }
    }

    /**
     * Solution 2: Use command stack to simulate recursive
     * Rationale refers to NO.144
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("visit",root));
        while(!stack.isEmpty()){
            Command c = stack.pop();
            if(c.s.equals("print")){
                res.add(c.node.val);
            }else{//c.s.equals("visit")
                stack.push(new Command("print",c.node));
                if(c.node.right != null)
                    stack.push(new Command("visit",c.node.right));
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

        _145BinaryTreePostorderTraversal b = new _145BinaryTreePostorderTraversal();
        List<Integer> list = b.postorderTraversal2(root);
        System.out.println(list.toString());
    }
}
