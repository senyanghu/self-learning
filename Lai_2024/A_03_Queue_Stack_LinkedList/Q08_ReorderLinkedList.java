package A_03_Queue_Stack_LinkedList;

import Utils.ListNode;

// See: https://github.com/senyanghu/DaddyPlaypen/blob/master/src/com/laioffer/hw03/queue_stack_linkedlist/Q11_ReorderLinkedList.java
// 一个复杂的题目是几个简单的题目合成的
// N1 -> N2 -> .......Nn
// (N1 -> Nn) -> (N2 -> Nn-1) ....
// step1: find the middle node
// step2: reverse the second half
// step3: merge the two linked list into one
// time complexity: O(N)
public class Q08_ReorderLinkedList {
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode middle = this.middleNode(head);
        ListNode secondHead = this.reverseLinkedList(middle.next);
        middle.next = null;
        ListNode firstHead = head;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (firstHead != null && secondHead != null) {
            cur.next = firstHead;
            firstHead = firstHead.next;
            cur.next.next = secondHead;
            secondHead = secondHead.next;
            cur = cur.next.next;
        }
        if (firstHead != null) {
            cur.next = firstHead;
        }
        return dummy.next;
    }

    private ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

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

    public static void main(String args[]) {
        Q08_ReorderLinkedList rll = new Q08_ReorderLinkedList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        // ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        // l4.next = l5;
        ListNode res = rll.reorder(l1);
        while (res != null) {
            System.out.print(res.value + " ");
            res = res.next;
        }
    }
}
