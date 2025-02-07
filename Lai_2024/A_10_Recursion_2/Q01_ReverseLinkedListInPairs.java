package A_10_Recursion_2;


import A_03_Queue_Stack_LinkedList.ListNode;

public class Q01_ReverseLinkedListInPairs {
    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode subHead = reverseInPairs(head.next.next);
        ListNode next = head.next;
        head.next = subHead;
        next.next = head;
        return next;
    }
}