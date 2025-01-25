package A_03_Queue_Stack_LinkedList;

public class Q09_PartitionLinkedList {
    public ListNode partition(ListNode head, int target) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);
        ListNode small = smallDummy;
        ListNode large = largeDummy;

        ListNode cur = head;
        while (cur != null) {
            if (cur.value < target) {
                small.next = cur;
                small = small.next;
            } else {
                large.next = cur;
                large = large.next;
            }
            cur = cur.next;
        }
        large.next = null;
        small.next = largeDummy.next;

        return smallDummy.next;
    }
}
