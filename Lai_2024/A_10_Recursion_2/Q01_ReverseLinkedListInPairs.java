package A_10_Recursion_2;


import Utils.ListNode;

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