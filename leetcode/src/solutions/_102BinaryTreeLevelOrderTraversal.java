package solutions;

import basic.TreeNode;

import java.util.*;

/**
 * NO.102 Binary Tree Level Order Traversal
 * Keywords:   Queue BFS, classic
 * Difficulty: Medium
 * Company:    Facebook, Linkedin, Microsoft, Amazon, Apple, Bloomberg
 */
public class _102BinaryTreeLevelOrderTraversal {

    /**
     * Rationale: use queue to make a level order traversal
     *             1
     *            / \
     *           /   \
     *          2     3
     *         / \   / \
     *        /   \ /   \
     *       4    5 6    7
     *  1.把二叉树的根1推入队列
     *  |  1  |
     *  |-----|
     *  |Queue|
     *
     *  2.循环：只要队列不为空，把队列的队首元素1弹出队列，并把1的左右孩子推入队
     *  |  2  |     拿出了1，进行相应操作
     *  |  3  |
     *  |-----|
     *  |Queue|
     *
     *  3.然后把队首元素2弹出队列，并把2的左右孩子4和5推入队
     *  |  3  |     拿出了2，进行相应操作
     *  |  4  |
     *  |  5  |
     *  |-----|
     *  |Queue|
     *
     *  4.然后把队首元素3弹出队列，并把3的左右孩子6和7推入队
     *  |  4  |     拿出了3，进行相应操作
     *  |  5  |
     *  |  6  |
     *  |  7  |
     *  |-----|
     *  |Queue|
     *
     *  5. 然后队列中的元素都没有左右孩子，所以从队首依次拿出后做响应操作后，整个层序遍历结束
     *
     *  用LinkedList作为queue, 按层序依次输出每一个元素 add(element):在队尾添加元素 remove():删除并返回队首元素
     */
    public List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode headNode = queue.remove();
            res.add(headNode.val);
            if(headNode.left != null)
                queue.add(headNode.left);
            if(headNode.right != null)
                queue.add(headNode.right);
        }
        return res;
    }

    /**
     * Solution: BFS 广度优先层序遍历
     * 每一层需要输出一个list
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelNodesAmount = queue.size();//这时队列的大小就是该层所有节点的数量，因为在每一层都是弹出节点后，推入它的孩子节点
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i < levelNodesAmount; i++){
                TreeNode frontNode = queue.remove();
                levelList.add(frontNode.val);
                if(frontNode.left != null)
                    queue.add(frontNode.left);
                if(frontNode.right != null)
                    queue.add(frontNode.right);
            }
            res.add(levelList);
        }
        return res;
    }

    /**
     * Solution: DFS & recursion 深度优先：需要了解当前结果集的大小和当前层数的关系
     * res的大小表明已经遍历了几层，例如res为[[3]，[9, 20]]时，表明遍历过了2层
     * level由于根节点从0开始计算，
     * 因此当level == res.size()时，表明该层刚开始遍历，还没有遍历过
     * 当level < res.size() 时，表明该层正在进行遍历
     *      *             3         level = 0
     *      *            / \
     *      *           /   \
     *      *          9     20     level = 1
     *      *               / \
     *      *              /   \
     *      *             15    7   level = 2
     */
    private void DFS(TreeNode node, int level, List<List<Integer>> res){
        if(node == null)
            return;
        if(level == res.size()){
            List<Integer> levelList = new ArrayList<>();
            levelList.add(node.val);
            res.add(levelList);
        }else{//level < res.size()
            res.get(level).add(node.val);
        }
        DFS(node.left,level+1,res);
        DFS(node.right,level+1,res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode x = new TreeNode(20);
        root.left = new TreeNode(9);
        root.right = x;
        x.left = new TreeNode(15);
        x.right = new TreeNode(7);

        _102BinaryTreeLevelOrderTraversal b= new _102BinaryTreeLevelOrderTraversal();
        List<List<Integer>> list = b.levelOrder(root);
        System.out.println(list.toString());
    }
}
