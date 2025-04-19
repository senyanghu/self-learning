package MongoDB;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
public class Q01_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] represents if string[0, i) can be successfully break into the word dict
        // i 的最大值等于 s.length() 所以整个dp的长度等于 s.length() + 1
        boolean[] dp = new boolean[s.length() + 1];

        Set<String> wordSet = new HashSet<>(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            if (wordSet.contains(s.substring(0, i))) {
                dp[i] = true;
                continue;
            }
            for (int j = 1; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
