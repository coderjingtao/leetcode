package solutions.amazon;

import basic.TreeNode;
import basic.TreeUtil;

import java.util.*;

/**
 * 863 All Nodes Distance K in Binary Tree
 * Keywords: Binary Tree
 * Difficulty: Medium
 * Company: Facebook, Amazon
 */
public class _863AllNodesDistanceKInBinaryTree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if(k == 0){
            res.add(target.val);
            return res;
        }
        Map<TreeNode, List<TreeNode>> graph = buildGraph(root);
        Set<TreeNode> visited = new HashSet<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        while(!queue.isEmpty() && k >= 0){
            int size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.poll();
                visited.add(node);
                if(k == 0){
                    res.add(node.val);
                }
                List<TreeNode> adjacentNodes = graph.get(node);
                for(TreeNode adjacency : adjacentNodes){
                    if(!visited.contains(adjacency)){
                        queue.offer(adjacency);
                    }
                }
            }
            k--;
        }
        return res;
    }
    private Map<TreeNode,List<TreeNode>> buildGraph(TreeNode root){
        Map<TreeNode,List<TreeNode>> graph = new HashMap<>();
        preOrder(root,graph);
        return graph;
    }
    private void preOrder(TreeNode root, Map<TreeNode,List<TreeNode>> graph){
        if(root == null) return;
        if(root.left != null){
            graph.computeIfAbsent(root,nodeList -> new ArrayList<>()).add(root.left);
            graph.computeIfAbsent(root.left,nodeList -> new ArrayList<>()).add(root);
        }
        if(root.right != null){
            graph.computeIfAbsent(root,nodeList -> new ArrayList<>()).add(root.right);
            graph.computeIfAbsent(root.right,nodeList -> new ArrayList<>()).add(root);
        }
        preOrder(root.left,graph);
        preOrder(root.right,graph);
    }

    public static void main(String[] args) {
        //TreeNode root = TreeUtil.buildCompleteBinaryTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        root.left = node5;
        root.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;
        TreeUtil.show(root);
        _863AllNodesDistanceKInBinaryTree s = new _863AllNodesDistanceKInBinaryTree();
        List<Integer> res = s.distanceK(root, node5, 2);
        System.out.println("res = " + res);
    }

}
