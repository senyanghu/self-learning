package A_03_Queue_Stack_LinkedList;

// Question: When should we maintain the dummy head?
//
// Answer:
// when we initially don't know which node will be the new
// head of a new linkedList. we can easily allocate a real memory for the dummy head.
// so we can APPEND the node to the dummy head
public class Q07_MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
