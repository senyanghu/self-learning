package A_加强练习2;

/*
dp[i][j]: 将从i到j的石头合并成一堆的最小代价
sum[i][j]: 从i到j的石头重量之和

Base case:
dp[i][i] = 0  // 单个石头不需要合并

Induction rule:
dp[i][j] = min(dp[i][k] + dp[k+1][j] + sum[i][j])
其中 k 从 i 到 j-1



 */
public class Q09_MergeStones {
    public int minCost(int[] stones) {
        if (stones == null || stones.length <= 1) {
            return 0;
        }

        int n = stones.length;
        // sum[i][j]表示从i到j的stones的总和
        int[][] sum = new int[n][n];
        // dp[i][j]表示将i到j的stones合并成一堆的最小代价
        int[][] dp = new int[n][n];

        // 初始化sum数组
        for (int i = 0; i < n; i++) {
            sum[i][i] = stones[i];
            for (int j = i + 1; j < n; j++) {
                sum[i][j] = sum[i][j-1] + stones[j];
            }
        }

        // 区间长度从2开始
        for (int len = 2; len <= n; len++) {
            // 遍历所有可能的起点
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;  // 终点
                dp[i][j] = Integer.MAX_VALUE;
                // 尝试在不同位置分割
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][k] + dp[k+1][j] + sum[i][j]);
                }
            }
        }

        return dp[0][n-1];
    }
}
