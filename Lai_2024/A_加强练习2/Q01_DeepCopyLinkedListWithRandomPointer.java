package A_加强练习2;

import Utils.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Here's the text from the image:
 * <p>
 * copy a linked list with random pointer
 * <p>
 * class Node {
 * int value;
 * Node* next;
 * Node* random;
 * }
 * <p>
 * input:
 * N1 -> N2 -> N3 -> N4 -> N5 -> NULL
 * |     |     ^           ^
 * |     |     |           |
 * |-----|-----            |
 * |-----------------|
 * <p>
 * output:
 * N1' -> N2' -> N3' -> N4' -> N5' -> NULL
 * |      |     ^            ^
 * |      |     |            |
 * |------|-----             |
 * |------------------|
 */

// 唯一的难点 建立origin和copy node的一一对应的关系 防止一个original node被重复copy一次以上
public class Q01_DeepCopyLinkedListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        // Lookup map to avoid duplicate. Key: original node. Value: copied node.
        Map<RandomListNode, RandomListNode> lookup = new HashMap<>();

        RandomListNode copyHead = new RandomListNode(head.value);
        lookup.put(head, copyHead);
        RandomListNode copyCursor = copyHead;

        while (head != null) {
            if (head.next != null) {    // copy next
                if (!lookup.containsKey(head.next)) {
                    // Hasn't been copied over due to random pointer.
                    lookup.put(head.next, new RandomListNode(head.next.value));
                }
                copyCursor.next = lookup.get(head.next);
            }

            if (head.random != null) {    // copy random
                if (!lookup.containsKey(head.random)) {
                    // Hasn't been copied over previously.
                    lookup.put(head.random, new RandomListNode(head.random.value));
                }
                copyCursor.random = lookup.get(head.random);
            }

            head = head.next; // 真list往前走一个
            copyCursor = copyCursor.next; // copy list往前走一个
        }

        return copyHead;
    }
}
