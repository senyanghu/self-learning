package A_加强练习1;

/**
 * classical way to print the tree level by level in a zig-zag way
 * [Tree diagram shows levels:
 * Level 1: 1
 * Level 2: 2, 3
 * Level 3: 4, 5, 6, 7
 * Level 4: 8, 9]
 * deque = { }
 * Example
 * → 1
 * ← 3 2
 * → 4 5 6 7
 * ← 9 8
 * Solution: use a deque
 * Case 1: if we are on odd level: do the same as that in BFS1.
 * expand a node from the left end of the deque, generate left child and then right child,
 * and insert them to the right end of the deque.
 * Case 2: if we are on even level: do the opposite as that in BFS1.
 * expand a node from the right end of the deque, generate right child and then left child,
 * and insert them to the left end of the deque.
 */
public class Q10_BinaryTreeZigZag {
}
