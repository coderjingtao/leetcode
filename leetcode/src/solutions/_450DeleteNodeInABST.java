package solutions;

import basic.BinaryTree;
import basic.TreeNode;
import basic.TreeUtil;

/**
 * NO.450 Delete Node in a BST
 * Keywords:   Binary Search Tree, BST, classic
 * Difficulty: Medium
 * Company: Uber
 */
public class _450DeleteNodeInABST {

    //Return the root node reference
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {// key == root.val i.e. root is the node to be deleted. return the new root
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else { // root.left != null && root.right != null
                TreeNode replaceNode = minimum(root.right); //用root的右子树中的最小值替代root即可
                replaceNode.right = del_minimum(root.right); //千万不要把给right和left孩子的赋值顺序弄反
                replaceNode.left = root.left;
                return replaceNode;
            }
        }
    }

    //return the root
    private TreeNode minimum(TreeNode root) {
        if (root.left == null)
            return root;
        return minimum(root.left);
    }

    //return the new root
    private TreeNode del_minimum(TreeNode root) {
        if (root.left == null) { // root is the minimum
            return root.right;
        }
        root.left = del_minimum(root.left);
        return root;
    }

    public static void main(String[] args) {
        _450DeleteNodeInABST test = new _450DeleteNodeInABST();
        BinaryTree bt = new BinaryTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeUtil.show(bt.root);
        TreeNode newRoot = test.deleteNode(bt.root, 3);
        TreeUtil.show(newRoot);
    }
}
