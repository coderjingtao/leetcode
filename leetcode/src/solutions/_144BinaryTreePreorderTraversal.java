package solutions;

import basic.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * NO.144 Binary Tree Preorder Traversal
 * Keywords:   Stack Recursive
 * Difficulty: Medium
 * Company:    Microsoft
 * Related:    NO.94 - Inorder, NO.145 - Postorder
 */
public class _144BinaryTreePreorderTraversal {
    /**
     * Solution 1: 递归 recursive
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root,result);
        return result;
    }
    private void preorder(TreeNode node, List<Integer> res){
        if(node != null){
            res.add(node.val);
            preorder(node.left,res);
            preorder(node.right,res);
        }
    }

    /**
     * Solution 2: 理解stack和 recursive的关系
     * 运用自定义系统栈来模拟递归过程  use customized stack to simulate recursive process in operating system
     *             1
     *            / \
     *           /   \
     *          2     3
     *  1.把访问根节点1压入栈
     *  |  visit 1  |
     *  |-----------|
     *  |   Stack   |
     *
     *  2.把访问1的命令visit 1 (栈顶命令)弹出栈，并按照前序顺序压入下面三个命名
     *  | print 1   |
     *  | visit 1-L |
     *  | visit 1-R |
     *  |-----------|
     *  |   Stack   |
     *
     *  3.然后依次弹出栈顶命令并执行，弹出打印1 --> 打印1 --> 弹出访问1的左孩子2 --> 压入相应的2的3条命令
     *  | print 2   |
     *  | visit 2-L |
     *  | visit 2-R |
     *  | visit 1-R |
     *  |-----------|
     *  |   Stack   |
     *
     *  4.依次弹出并执行命令，由于2的左右孩子都为空，则不会进入下一层，所以弹出并执行到visit 1-R 时，压入3的信息
     *  | print 3   |
     *  | visit 3-L |
     *  | visit 3-R |
     *  |-----------|
     *  |   Stack   |
     *
     *  5.依次弹出并执行命令，由于3的左右孩子都为空，则此时栈为空了，结束遍历
     *
     * 总结：系统栈记录递归函数每一层执行的信息，当递归函数某一层执行完后返回上一层时，系统栈能够知道从哪里开始继续向下执行
     * 每次从栈顶的元素开始访问执行：每遇到visit节点，则打印节点，并visit left and visit right
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        Stack<Command> systemStack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        systemStack.push(new Command("visit",root));
        while (!systemStack.isEmpty()){
            Command command = systemStack.pop();
            if(command.s.equals("print"))
                res.add(command.node.val);
            else{ // command.s.equals("visit")
                if(command.node.right != null)
                    systemStack.push(new Command("visit",command.node.right));
                if(command.node.left != null)
                    systemStack.push(new Command("visit",command.node.left));
                systemStack.push(new Command("print", command.node));
            }
        }
        return res;
    }

    /**
     * Solution 3: 理解了stack的基本运行原理后，简化Solution 2
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)
            return res;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            res.add(curNode.val);
            if(curNode.right != null)
                stack.push(curNode.right);
            if(curNode.left != null)
                stack.push(curNode.left);
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] input = {1,null,2,3};
        TreeNode root = new TreeNode(1);
        TreeNode x = new TreeNode(2);
        TreeNode y = new TreeNode(3);
        root.right = x;
        x.left = y;

        _144BinaryTreePreorderTraversal b = new _144BinaryTreePreorderTraversal();
        List<Integer> list = b.preorderTraversal3(root);
        System.out.println(list.toString());
    }
}

class Command{
    String s; //command = visit, print
    TreeNode node;
    Command(String s, TreeNode node){
        this.s = s;
        this.node = node;
    }
}
