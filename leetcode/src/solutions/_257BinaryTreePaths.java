package solutions;

import basic.BinaryTree;
import basic.TreeNode;
import basic.TreeUtil;

import java.util.*;

/**
 * NO.257 Binary Tree Paths
 * Keywords:   Binary Tree, Classic
 * Difficulty: Easy
 * Company: Google, Facebook, Apple
 */
public class _257BinaryTreePaths {

    //Recursion 需要把方法定义清晰

    /**
     * 返回以root为根节点的所有路径的总和
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths =  new ArrayList<>();
        if(root == null)
            return paths;
        if(root.left == null && root.right == null) { //leaf node
            paths.add(String.valueOf(root.val));
            return paths;
        }
        List<String> leftPaths = binaryTreePaths(root.left);//返回以左子树为根的所有路径
        for(int i=0; i < leftPaths.size();i++)
            paths.add(root.val+"->"+leftPaths.get(i));

        List<String> rightPaths = binaryTreePaths(root.right);//返回以右子树为根的所有路径
        for(int i=0; i<rightPaths.size();i++)
            paths.add(root.val+"->"+rightPaths.get(i));

        return paths;
    }

    public static void main(String[] args) {
        _257BinaryTreePaths test = new _257BinaryTreePaths();
        BinaryTree bt = new BinaryTree(new Integer[]{1,2,3,null,5});
        TreeUtil.show(bt.root);
        List<String> ret = test.binaryTreePaths(bt.root);
        for ( String s: ret) {
            System.out.println(s);
        }
    }
}
