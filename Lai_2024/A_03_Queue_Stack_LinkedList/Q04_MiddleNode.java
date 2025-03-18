package A_03_Queue_Stack_LinkedList;

import Utils.ListNode;

/*
奇数长度 (1->2->3->4->5):
- 返回正中间的节点 (3)

偶数长度 (1->2->3->4):
- 返回中间偏左的节点 (2)

这样做的好处是永远对于下半截的List的头有所控制
 */
public class Q04_MiddleNode {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
