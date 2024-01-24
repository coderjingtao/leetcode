package basic;

/**
 * 双向链表的节点
 * @author joseph
 * @create 2024-01-24
 */
public class ListNode2 {
    public int val;//节点值
    public ListNode2(int x){//构造函数
        val = x;
    }
    public ListNode2 prev;//指向上一个节点的引用
    public ListNode2 next;//指向下一个节点的引用
}
