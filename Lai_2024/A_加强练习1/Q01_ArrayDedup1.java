package A_加强练习1;

import java.util.Arrays;

/**
 * Given a sorted integer array, remove duplicate elements. For each group of
 * elements with the same value keep only one of them. Do this in-place, using
 * the left side of the original array and maintain the relative order of the
 * elements of the array. Return the array after deduplication. Assumptions
 * <p>
 * The array is not null
 * <p>
 * Examples
 * <p>
 * {1, 2, 2, 3, 3, 3} -> {1, 2, 3}
 * <p>
 * return the number of elements being reserved
 */
public class Q01_ArrayDedup1 {
    // slow: all elements to the left hand side of slow (INcluding slow) are the
    // results
    // fast: current index
    public int dedup_including(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[slow] == array[fast]) {
                continue;
            }
            array[++slow] = array[fast];
        }
        return slow + 1;
    }

    // slow: all elements to the left hand side of slow (EXcluding slow) are the
    // results
    // fast: current index
    public int dedup_excluding(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int slow = 1;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[slow - 1] == array[fast]) {
                continue;
            }
            array[slow++] = array[fast];
        }
        return slow;
    }
}
