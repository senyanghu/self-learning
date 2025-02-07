package A_11_DP_1;

// base case: M[n - 1] = true
// induction rule
//          M[i] represents weather we could reach the target from i-th index
//          M[i] == true iff there exists a j, where M[j] = true and j - i <= input[i]
//                  false otherwise
public class Q03_ArrayHopper {
    public boolean canJump(int[] array) {
        boolean[] dp = new boolean[array.length];
        dp[array.length - 1] = true;

        for (int i = array.length - 2; i >= 0; i--) {
            for (int j = array.length - 1; j > i; j--) {
                if (dp[j] && (j - i) <= array[i]) {
                    dp[j] = true;
                }
            }
        }
        return dp[0];
    }
}
