package MongoDB;

import Utils.ListNode;

import java.util.PriorityQueue;

public class Q11_MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((l1, l2) -> l1.value - l2.value);

        // put the head of each list into the minHeap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode ln = minHeap.poll();
            cursor.next = ln;
            cursor = cursor.next;

            if (ln.next != null) {
                minHeap.add(ln.next);
            }
        }

        return dummy.next;
    }
}
