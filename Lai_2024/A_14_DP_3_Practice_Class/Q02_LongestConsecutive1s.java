package A_14_DP_3_Practice_Class;

// M[i] represents the length of the longest subarray of consecutive 1s, ending with array[i]

// M[0] = 0 iff array[i] == 0
// M[0] = 1 iff array[i] == 1

// M[i] = M[i-1] + 1; if A[i] == 1
// M[i] = 0; if A[i] == 0
public class Q02_LongestConsecutive1s {
    public int longest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int curLength = array[0];
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 1) {
                curLength = curLength + 1;
            } else {
                curLength = 0;
            }
            result = Math.max(result, curLength);
        }
        return result;
    }

    public static void main(String[] args) {
        Q02_LongestConsecutive1s sol = new Q02_LongestConsecutive1s();
        int[] array = {0, 1, 1, 0, 1, 1, 1, 0, 1};
        System.out.println(sol.longest(array));
    }
}
