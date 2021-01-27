package basic;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    public TreeNode root;
    public BinaryTree(){

    }
    public BinaryTree(int[] array){
        List<TreeNode> nodeList = new LinkedList<TreeNode>();

        // 将数组的值转换为node
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new TreeNode(array[nodeIndex]));
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

    public BinaryTree(Integer[] arr){
        List<TreeNode> nodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        for(int i=0; i<arr.length;i++){
            if(arr[i] != null)
                nodes.add(new TreeNode(arr[i]));
            else
                nodes.add(null);
        }
        int i = 0;
        queue.add(nodes.get(i));
        while(!queue.isEmpty() && i< nodes.size()-1){
            TreeNode parent = queue.poll();
            if(parent != null){
                parent.left = nodes.get(++i);
                parent.right = nodes.get(++i);
                queue.add(parent.left);
                queue.add(parent.right);
            }
        }
        root = nodes.get(0);
    }

    public void construct(Integer[] arr){
        List<TreeNode> nodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        for(int i=0; i<arr.length;i++){
            if(arr[i] != null)
                nodes.add(new TreeNode(arr[i]));
            else
                nodes.add(null);
        }
        int i = 0;
        queue.add(nodes.get(i));
        while(!queue.isEmpty() && i< nodes.size()-1){
            TreeNode parent = queue.poll();
            if(parent != null){
                parent.left = nodes.get(++i);
                parent.right = nodes.get(++i);
                queue.add(parent.left);
                queue.add(parent.right);
            }
        }
        root = nodes.get(0);
    }
}
