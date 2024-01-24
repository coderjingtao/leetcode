package solutions;

import datastructure.tree.BinaryTree;
import basic.TreeNode;
import basic.TreeUtil;

import java.util.*;

/**
 * NO.107 Binary Tree Level Order Traversal 2
 * Keywords:   Binary Tree, classic
 * Difficulty: Easy
 * Company:
 * Relation: #102
 */
public class _107BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = BFS(root);
        Collections.reverse(levels);
        return levels;
//        List<List<Integer>> res = new ArrayList<>();
//        DFS(root,0,res);
//        Collections.reverse(res);
//        return res;
    }

    // 层序遍历，广度优先
    private List<List<Integer>> BFS(TreeNode node){
        List<List<Integer>> levels = new ArrayList<>();
        if(node == null)
            return levels;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int levelNodesAmount = queue.size();//就是该层所有节点的数量，因为在每一层都是弹出节点后，推入它的孩子节点
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelNodesAmount; i++) {
                TreeNode oneNode = queue.poll();
                level.add(oneNode.val);
                if(oneNode.left != null)
                    queue.add(oneNode.left);
                if(oneNode.right != null)
                    queue.add(oneNode.right);
            }
            levels.add(level);
        }
        return levels;
    }

    // Recursion: 需要了解结果集的大小和当前层数的关系
    private void DFS(TreeNode node, int levelNum, List<List<Integer>> res){
        if(node == null)
            return;
        //res的大小表明已经遍历了几层，例如res为[[3]，[9, 20]]时，表明遍历过了2层
        //由于levelNum是从0开始计算的，root的levelNum=0，因此当levelNum == res.size()时，表明该层还没有遍历
        if(res.size() == levelNum){
            List<Integer> levelList = new ArrayList<>();
            levelList.add(node.val);
            res.add(levelList);
        }
        else{//res.size() > levelNum) 表明res已经在遍历levelNum层了
            res.get(levelNum).add(node.val);
        }
        DFS(node.left,levelNum+1,res);
        DFS(node.right,levelNum+1,res);
    }

    public static void main(String[] args) {
        _107BinaryTreeLevelOrderTraversal2 test = new _107BinaryTreeLevelOrderTraversal2();
        BinaryTree bt = new BinaryTree(new Integer[]{3,9,20,null,null,15,7});
        TreeUtil.show(bt.root);
        List<List<Integer>> levels = test.levelOrderBottom(bt.root);
        System.out.println(Arrays.toString(levels.toArray()));
    }

}
