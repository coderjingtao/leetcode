package datastructure.tree;

import basic.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    public TreeNode root;
    public BinaryTree(){

    }

    /**
     * 通过数组构建完全二叉树(Complete Binary Tree): 只有最底层的节点未被填满，且最底层节点尽量靠左填充
     * @param array 构建数组
     */
    public BinaryTree(int[] array){
        List<TreeNode> nodeList = new LinkedList<>();

        // 将数组的值转换为node
        for (int i : array) {
            nodeList.add(new TreeNode(i));
        }

        // 对除最后一个父节点按照父节点和孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }

        // 最后一个父节点
        int lastParentIndex = array.length / 2 - 1;

        // 左孩子
        nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);

        // 如果为奇数，建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
        }

        root = nodeList.get(0);
    }

    /**
     * 构建基于LeetCode的Binary Tree
     * 该BinaryTree的特点是，只给出非null节点的左右子节点，例如：[0,null,1,null,2,null,3,4]
     * 相比于用完美二叉树(满二叉树)和null节点来构建普通二叉树，会省略存储一部分的null值
     * @param nodes 构建node数组
     */
    public BinaryTree(Integer[] nodes){
        if(nodes == null || nodes.length == 0) throw new RuntimeException("nodes cannot be empty");
        int i = -1;
        root = new TreeNode(nodes[++i]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                if(i + 1 < nodes.length){
                    Integer leftVal = nodes[++i];
                    if(leftVal != null){
                        TreeNode leftNode = new TreeNode(leftVal);
                        node.left = leftNode;
                        queue.offer(leftNode);
                    }
                }
                if(i + 1 < nodes.length){
                    Integer rightVal = nodes[++i];
                    if(rightVal != null){
                        TreeNode rightNode = new TreeNode(rightVal);
                        node.right = rightNode;
                        queue.offer(rightNode);
                    }
                }
            }
        }
    }
}
