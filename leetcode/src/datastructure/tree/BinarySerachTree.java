package datastructure.tree;

import basic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: One Binary Search Tree with various functions.
 * Created by Jingtao Liu on 31/01/2020.
 */
public class BinarySerachTree {

    public TreeNode root;

    public void insert(int val) {
        root = insert(root, val);
    }

    public boolean contain(int val) {
        return contain(root, val);
    }

    public TreeNode find(int val) {
        return find(root, val);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void levelOrder() {
        levelOrder(root);
    }

    public TreeNode minimum() {
        if (root == null)
            return null;
        return minimum(root);
    }

    public TreeNode maximum() {
        if (root == null)
            return null;
        return maximum(root);
    }

    public void deleteMin() {
        if (root != null)
            root = deleteMin(root);
    }

    public void deleteMax() {
        if (root != null)
            root = deleteMax(root);
    }

    public void remove(int val) {
        if (contain(val))
            root = remove(root, val);
    }

    /**
     * 向以node为根的二叉搜索树中，插入值value
     * 返回插入新节点后的二叉搜索树的[根]
     */
    private TreeNode insert(TreeNode node, int val) {

        if (node == null)
            return new TreeNode(val);
        if (val == node.val)
            node.val = val;
        else if (val < node.val)
            node.left = insert(node.left, val);
        else // val > node.val
            node.right = insert(node.right, val);

        return node;
    }

    /**
     * 查找以node为根的二叉搜索树中是否包含值value
     * 包含返回true，不包含返回false
     */
    private boolean contain(TreeNode node, int val) {
        if (node == null)
            return false;
        if (val == node.val)
            return true;
        else if (val < node.val)
            return contain(node.left, val);
        else
            return contain(node.right, val);
    }

    /**
     * 查找以node为根的二叉搜索树中是否包含值value
     * 包含返回该节点，不包含返回null
     * 该方法的缺点：暴漏了数据结构TreeNode
     */
    private TreeNode find(TreeNode node, int val) {
        if (node == null)
            return null;
        if (val == node.val)
            return node;
        else if (val < node.val)
            return find(node.left, val);
        else
            return find(node.right, val);
    }

    /**
     * 深度优先遍历：前序遍历
     */
    private void preOrder(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /*
     * 深度优先遍历：中序遍历
     */
    private void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.val);
            inOrder(node.right);
        }
    }

    /**
     * 深度优先遍历：后序遍历
     */
    private void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.val);
        }
    }

    /**
     * 广度优先遍历：层序遍历
     */
    private void levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (node != null)
            queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode n = queue.remove();
            System.out.println(n.val);
            if (n.left != null)
                queue.add(n.left);
            if (n.right != null)
                queue.add(n.right);
        }
    }

    private TreeNode minimum(TreeNode node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    private TreeNode maximum(TreeNode node) {
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    /**
     * 删除以node为根的二分搜索树中的最小节点
     * 返回： 删除节点后新的二分搜索树的根
     */
    private TreeNode deleteMin(TreeNode node) {

        if (node.left == null) { // 这时的node就是最小值节点
            TreeNode right = node.right; //这时node的右孩子就需要代替node成为新树的根，为null也没事
            node.right = null; //断开该节点与它的右孩子
            return right;//返回新节点
        }
        node.left = deleteMin(node.left);
        return node;
    }

    /**
     * 删除以node为根的二分搜索树中的最大节点
     * 返回： 删除节点后新的二分搜索树的根
     */
    private TreeNode deleteMax(TreeNode node) {
        if (node.right == null) { // 这时的node就是最大值节点
            TreeNode left = node.left;//这时node的左孩子就需要代替node成为新树的根，为null也没事
            node.left = null; //断开该节点
            return left;
        }
        node.right = deleteMax(node.right);
        return node;
    }

    /**
     * Hubbard Deletion
     * 删除以node为根的二分搜索树中值为val的节点
     * 返回： 删除节点后新的二分搜索树的根
     */
    private TreeNode remove(TreeNode node, int val) {
        //1.利用递归查找val所在的节点
        if (node == null)
            return null;
        if (val < node.val) {
            node.left = remove(node.left, val);
            return node;
        } else if (val > node.val) {
            node.right = remove(node.right, val);
            return node;
        } else {//2. val == node.val 找到了要删除的节点

            //3. 左孩子为空或右孩子为空，直接把其右孩子或左孩子当作新的根返回即可
            if (node.left == null) {
                TreeNode newRightNode = node.right;
                node.right = null;
                return newRightNode;
            }

            if (node.right == null) {
                TreeNode newLeftNode = node.left;
                node.left = null;
                return newLeftNode;
            }
            //4. 当node的左右孩子都不为空
            TreeNode successor = minimum(node.right);//找到代替node的节点，即node右子树的最小值节点

            successor.right = deleteMin(node.right);//把删出了最小值的右子树指定为successor的右子树
            successor.left = node.left; //把node的左子树指定为successor的左孩子

            node= null; //删除掉node
            return successor;//返回替代者
        }
    }
}
