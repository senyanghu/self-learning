package A_加强练习2;

import Utils.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
How to merge K sorted arrays into one big sorted array


assumptions:
- length
- ascending / descending
- duplicate
- data type
- fit in memory
 */
public class Q03_MergeKSortedArray {
    public List<Integer> merge(int[][] arrayOfArrays) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> {
            if (e1.value == e2.value) {
                return 0;
            } else if (e1.value < e2.value) {
                return -1;
            } else {
                return 1;
            }
        });


        for (int i = 0; i < arrayOfArrays.length; i++) {
            int[] array = arrayOfArrays[i];
            if (array.length != 0) {
                pq.add(new Element(i, 0, array[0]));
            }
        }

        while (!pq.isEmpty()) {
            Element e = pq.poll();
            result.add(e.value);
            if (e.y < arrayOfArrays[e.x].length - 1) {
                pq.add(new Element(e.x, e.y + 1, arrayOfArrays[e.x][e.y + 1]));
            }
        }

        return result;
    }
}
