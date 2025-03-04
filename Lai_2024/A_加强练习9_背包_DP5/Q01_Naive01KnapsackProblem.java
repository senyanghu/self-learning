package A_加强练习9_背包_DP5;

/*
Given N items, each item has weight, weight[i] ...
Knapsack has a weight capacity W, what is the maximum total weight you can get?

Example:
W = 8
weight[] = 4 3 8

Answer
基本思想 左大段 + 右小段

Let's use boolean M[i, w] to represent whether we can get exactly weight = w by using the first i items
(may not include the i-th item).
Example:
M[2, 5] = false
M[2, 7] = true

Base case:
1. M[0, 0] = true                // you can always use 0 items to get weight 0
2. M[0, 1] ... M[0, W] = false   // you cannot use 0 items to get weight > 0

M[i, w]: we are looking at the i-th item. (its weight is weights[i])
M[i, w] = M[i-1, w] || M[i-1, w - weights[i]]

(不取第 i 个 item) If you can use the first i-1 items to get weight = w (左大段), then you can skip the i-th item to get weight = w as well (右小段).
(取第 i 个 item) If you can use the first i-1 items to get weight = w - weights[i] (左大段), then you can pick the i-th item to get weight = (w - weights[i]) + weights[i] = w (右小段).
 */
public class Q01_Naive01KnapsackProblem {
    public int getMaxWeight(int[] weights, int maxWeight) {
        if (weights == null || weights.length == 0 || maxWeight <= 0) {
            return 0;
        }

        // M[i, w]: we are looking at the i-th item. (its weight is weights[i])
        boolean[][] dp = new boolean[weights.length + 1][maxWeight + 1];
        dp[0][0] = true;
        for (int j = 1; j <= maxWeight; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i < weights.length; i++) {
            dp[i][0] = true;
        }

        int res = 0;
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                dp[i][j] = dp[i - 1][j] || (j >= weights[i - 1] && dp[i - 1][j - weights[i - 1]]);
                if (dp[i][j]) {
                    res = Math.max(res, j);
                }
            }
        }

        return res;
    }
}
