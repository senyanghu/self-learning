package A_加强练习7_DP4;

/*
M[i] represents from the 0th-ith element, the value of the longest
ascending subsequence (including the ith element)

Base case:
M[0] = 1

Induction Rule:
M[i] = max(M[j]) + 1    where input[i] > input[j] for 0 <= j < i
M[i] = 1                when there is no such j

Time = O(n^2)
 */
public class Q04_LongestAscendingSubsequence {
    public int longest(int[] array) {
        // corner case
        if (array == null || array.length == 0) {
            return 0;
        }

        int[] M = new int[array.length];
        // base case
        M[0] = 1;

        int globalMax = 1;
        // induction rule
        for (int i = 1; i < array.length; i++) {
            // default value for M[i]
            M[i] = 1;

            // check all previous elements
            for (int j = 0; j < i; j++) {
                // if current element is larger than previous one
                if (array[i] > array[j]) {
                    M[i] = Math.max(M[i], M[j] + 1);
                }
            }

            // update global maximum
            globalMax = Math.max(globalMax, M[i]);
        }

        return globalMax;
    }
}
