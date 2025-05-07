package MongoDB;

import java.util.PriorityQueue;

class Element {
    int index;
    int value;

    Element(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

public class Q10_MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Element> maxHeap = new PriorityQueue<>((e1, e2) -> e2.value - e1.value);

        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(new Element(i, nums[i]));

            // we decide to calculate as we meet up with the window when i >= k - 1
            // window range is represented as [i-k+1, i]
            if (i >= k - 1) {
                while (!maxHeap.isEmpty() && maxHeap.peek().index < i - k + 1) {
                    maxHeap.poll();
                }
                res[i - k + 1] = maxHeap.peek().value;
            }
        }

        return res;
    }
}
