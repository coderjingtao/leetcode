package solutions.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * 138 Copy List with Random Pointer
 * Keywords: HashMap
 * Difficulty: Medium
 * Company: Facebook, Amazon
 */
public class _138CopyListRandomPointer {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.computeIfAbsent("joseph",v -> "123");
        map.forEach((k,v) -> {
            System.out.println(k +" : "+v);
        });
    }
    Map<MyNode,MyNode> copyMap = new HashMap<>();

    private void traverseMap(MyNode head){
        while(head != null){
            MyNode copiedHead = new MyNode(head.val);
            copyMap.put(head,copiedHead);
            head = head.next;
        }
    }

    public MyNode copyRandomList(MyNode head) {
        if(head == null) return null;
        traverseMap(head);
        MyNode newHead = copyMap.get(head);
        MyNode copiedHead = newHead;
        while(head != null){
            MyNode next = head.next;
            MyNode random = head.random;
            //copy
            MyNode copiedNext = copyMap.get(next);
            MyNode copiedRandom = copyMap.get(random);
            copiedHead.next = copiedNext;
            copiedHead.random = copiedRandom;
            //move forward
            head = head.next;
            copiedHead = copiedHead.next;
        }
        return newHead;
    }
}

class MyNode {
    int val;
    MyNode next;
    MyNode random;

    public MyNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
