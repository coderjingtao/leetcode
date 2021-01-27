package solutions;

import basic.TreeNode;
import basic.TreeUtil;

import java.util.Arrays;

/**
 * NO.108 Delete Node in a BST
 * Keywords:   Binary Search Tree, BST
 * Difficulty: Easy
 * Company: Airbnb
 */
public class _108ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        if(nums.length == 1){
            return new TreeNode(nums[0]);
        }
        int mid = nums.length / 2 -1 ;
        if(nums.length % 2 == 1)
            mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        int[] left = Arrays.copyOfRange(nums,0,mid);
        int[] right = Arrays.copyOfRange(nums,mid+1,nums.length);
        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);
        return root;
    }

    public static void main(String[] args) {
        _108ConvertSortedArrayToBinarySearchTree test = new _108ConvertSortedArrayToBinarySearchTree();
        TreeNode root = test.sortedArrayToBST(new int[]{1,2,3,4,5,6});
        TreeUtil.show(root);
    }
}
