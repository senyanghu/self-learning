package A_加强练习7_DP4;

/*
A[] = sweDEN
B[] = stuDENt
For example, the common substring between sweden and student is DEN.
 */
public class Q02_LongestCommonSubstring {

    /*
M[i][j] represents the longest common substring between first i letters in text1 and first j letters in text2.
it represents the common part between text1[0, i-1] and text2[0, j-1].
text1[0, -1] is actually empty.

M[0][0] = 0
M[0][j] = 0 for all the j
M[i][0] = 0 for all the i

Induction Rule:
M[i][j] = M[i - 1][j - 1] + 1 if text1[i] == text2[j]
        = 0                   if text1[i] != text2[j]

让我用一个具体的例子来解释为什么不匹配时要重置为 0。

考虑两个字符串：
s1 = "abcd"
s2 = "abce"

让我们一步步填写 DP 表：
   "" a b c e
"" 0  0 0 0 0
a  0  1 0 0 0
b  0  0 2 0 0
c  0  0 0 3 0
d  0  0 0 0 0  <- 这里 d != e，所以是0

为什么 d 和 e 不匹配时要设为 0？

因为我们要找的是连续的公共子串：
- 当 d != e 时，以 d 和 e 结尾的子串不可能是公共子串
- 如果不重置为 0，而是保留前面的值，就变成了最长公共子序列问题
 */
    public int longestCommonSubstring(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;

        // base case 已经默认为0

        // induction rule
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
                // else 的情况 dp[i][j] 保持为 0
                else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }
}
