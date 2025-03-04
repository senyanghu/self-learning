package A_加强练习9_背包_DP5;

/*
Given a set of N items, each item has a weight[i] and a value v[i] (i = 1, 2 ... N)
The knapsack has a weight capacity W, what is the maximum total value you can get


Recall the solution of the classic 0/1 knapsack problem:
• M[i, w]: By using the first i items, the maximum total value to get weight = w.
• Base case: M[0, 0] = 0
• Induction rule: M[i, w] = max(M[i-1, w], M[i-1, w - weights[i]] + v[i])
 */
public class Q02_Classic01KnapsackProblem {
    public int maxWeightGet(int[] weights, int[] v, int maxWeight) {
        if (weights == null || weights.length == 0) {
            return 0;
        }
        int MW = Integer.MIN_VALUE;
        int[][] M = new int[weights.length + 1][maxWeight + 1];
        M[0][0] = 0;
        for (int i = 1; i <= maxWeight; i++) {
            M[0][i] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                M[i][j] = Math.max(M[i - 1][j], (j >= weights[i - 1] ?
                        M[i - 1][j - weights[i - 1]] + v[i - 1] : Integer.MIN_VALUE));
                MW = Math.max(MW, M[i][j]);
            }
        }
        return MW;
    }
}
