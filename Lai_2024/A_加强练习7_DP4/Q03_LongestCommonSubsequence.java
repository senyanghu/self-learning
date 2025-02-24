package A_加强练习7_DP4;

/*
A == StuDENt
B == SweDEN

M[i][j] represents the longest common subsequence between first i letters in text1 and first j letters in text2.
it represents the common subsequence between text1[0, i-1] and text2[0, j-1].

M[0][0] = 0
M[0][j] = 0 for all the j
M[i][0] = 0 for all the i

Induction Rule:
M[i][j] = M[i - 1][j - 1] + 1                             if text1[i] == text2[j]
        = MAX(M[i - 1][j], M[i][j - 1])                   if text1[i] != text2[j]
 */
public class Q03_LongestCommonSubsequence {
    // 经典动态规划解法
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }

        int m = text1.length();
        int n = text2.length();

        // 创建DP表，M[i][j]表示text1前i个字符和text2前j个字符的LCS长度
        int[][] M = new int[m + 1][n + 1];

        // 初始化边界条件（其实不用显式初始化，因为数组默认值就是0）
        for (int i = 0; i <= m; i++) {
            M[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            M[0][j] = 0;
        }

        // 填充DP表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    M[i][j] = M[i - 1][j - 1] + 1;
                } else {
                    M[i][j] = Math.max(M[i - 1][j], M[i][j - 1]);
                }
            }
        }

        return M[m][n];
    }
}
