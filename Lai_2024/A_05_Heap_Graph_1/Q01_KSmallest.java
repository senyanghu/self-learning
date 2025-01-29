package A_05_Heap_Graph_1;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q01_KSmallest {
    public int[] kSmallest(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0 || k >= array.length) {
            return array;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int element : array) {
            maxHeap.offer(element);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
