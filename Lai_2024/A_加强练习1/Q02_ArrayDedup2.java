package A_加强练习1;

import java.util.Arrays;

/**
 * 跟上面一条题目相比 最多保留两个元素怎么做？
 * <p>
 * Given a sorted integer array, remove duplicate elements. For each group of
 * elements with the same value keep at most two of them. Do this in-place,
 * using the left side of the original array and maintain the relative order of
 * the elements of the array. Return the array after deduplication. Assumptions
 * <p>
 * The given array is not null
 * <p>
 * Examples {1, 2, 2, 3, 3, 3} -> {1, 2, 2, 3, 3}
 */
public class Q02_ArrayDedup2 {
    public int dedup_excluding(int[] array) {
        if (array == null || array.length <= 2) {
            return 0;
        }
        // slow: all elements to the left hand side of slow (excluding slow) are the
        // results, slow index points the available spot
        // fast: current index
        // 因为保留两个元素 所以index 0和1是一定需要保存的 那么就从index=2 开始
        // fast 指针一定比 >= slow
        int slow = 2;
        for (int fast = 2; fast < array.length; fast++) {
            if (array[slow - 2] == array[fast]) {
                continue;
            } else {
                array[slow++] = array[fast];
            }
        }
        return slow;
    }
}
