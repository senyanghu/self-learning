package A_14_DP_3_Practice_Class;

// M[i] represents the largest sum including i-th element

// induction rule:
// base case: M[0] = array[0]
// M[i] = M[i-1] + array[i] iff M[i-1] > 0
// M[i] = array[i]
public class Q01_LargestSumSubarray {
    public int largestSum(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int[] M = new int[array.length];
        int max = Integer.MIN_VALUE;
        M[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            if (M[i - 1] > 0) {
                M[i] = M[i - 1] + array[i];
            } else {
                M[i] = array[i];
            }
            max = Math.max(max, M[i]);
        }
        return max;
    }
}
