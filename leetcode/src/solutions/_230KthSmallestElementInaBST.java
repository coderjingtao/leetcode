package solutions;

import basic.BinaryTree;
import basic.TreeNode;
import basic.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class _230KthSmallestElementInaBST {

    //Solution 1: Inorder iteration and store in a List
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> numList = new ArrayList<>();
        inorder(root,numList);
        return numList.get(k-1);
    }

    private void inorder(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    //Solution 2: 中序遍历时，每次遍历到root时，都是按从小到大的顺序的
    int order;
    int res;
    public int kthSmallest2(TreeNode root, int k) {
        order = k;
        inorder(root);
        return res;
    }
    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        if(--order == 0)
            res = root.val;
        inorder(root.right);
    }

    public static void main(String[] args) {
        _230KthSmallestElementInaBST test = new _230KthSmallestElementInaBST();
        BinaryTree bt = new BinaryTree(new Integer[]{3,1,4,null,2});
        TreeUtil.show(bt.root);
        int res = test.kthSmallest2(bt.root,1);
        System.out.println(res);
    }
}
