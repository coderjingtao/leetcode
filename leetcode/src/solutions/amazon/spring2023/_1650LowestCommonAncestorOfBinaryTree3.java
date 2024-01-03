package solutions.amazon.spring2023;

import java.util.HashSet;
import java.util.Set;

/**
 * 1650 Lowest Common Ancestor of a Binary Tree 3
 * Keywords:   Binary Tree, LCA, classic
 * Difficulty: Medium
 * Company: Amazon
 */
public class _1650LowestCommonAncestorOfBinaryTree3 {

    public Node lowestCommonAncestor(Node p, Node q) {
        //recode the path from the node p to root
        Set<Node> path = new HashSet<>();
        while(p != null){
            path.add(p);
            p = p.parent;
        }
        while(q != null){
            if(path.contains(q)){//if q is on the path of p
                return q;
            }
            q = q.parent;
        }
        return null;
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};