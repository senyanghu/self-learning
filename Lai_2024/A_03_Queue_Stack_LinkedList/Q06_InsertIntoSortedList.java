package A_03_Queue_Stack_LinkedList;

import Utils.ListNode;

public class Q06_InsertIntoSortedList {
    public ListNode insertIntoSortedList(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null || value <= head.value) {
            newNode.next = head;
            return newNode;
        }

        ListNode cur = head;
        while (cur.next != null && cur.next.value < value) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        return head;
    }
}
