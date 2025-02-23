package A_加强练习6_BinarySearch;

// Sliding window of size k, always return the max element in the window size
/*
Here's the text from the image:

Solution 1: MaxHeap

Initialization: insert all first k elements into the maxheap.

Then: When the sliding window moves to the right by 1 step...
- 1 new element (from right side) comes in => MaxHeap.push(X)
- 1 left-most element should be removed from the sliding window
(but we can temporarily keep it in the heap until it becomes the top element in the heap)

Heap = {1 3 2 5}

Lazy deletion: when we want to call MaxHeap.top(), the only thing we should be careful about is to check whether
this top element's index is < left border of the sliding window. If so, keep popping it out.

check notes.pdf for time complexity

class Element {
    int value;
    int index;
}
 */
public class Q03_MaxNumInSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return null;
    }
}
