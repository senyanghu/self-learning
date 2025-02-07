package A_11_DP_1;

/**
 * input 7 2 3 1 5 8 9 6
 * <p>
 * 1. Base case M[0] = 1
 * <p>
 * 2. Induction rule:
 * M[i] represents [0th element - i-th element] the length of the longest ascending subarray,
 * including the input[i] element
 * <p>
 * M[i] = 1 + M[i - 1] iff input[i] > input[i - 1]
 * M[i] = 1 				otherwise
 */
public class Q01_LongestAscendingSubarray {

    public int longest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int[] M = new int[array.length];
        M[0] = 1;
        int longest = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                M[i] = M[i - 1] + 1;
            } else {
                M[i] = 1;
            }
            longest = Math.max(longest, M[i]);
        }
        return longest;
    }

    public static void main(String args[]) {
        Q01_LongestAscendingSubarray las = new Q01_LongestAscendingSubarray();
        int[] input = {7, 2, 3, 1, 5, 8, 9, 6};
        System.out.println(las.longest(input));
    }
}
