package A_09_String2;

import java.util.HashSet;
import java.util.Set;

// When to move fast: when sliding window do NOT have duplicate letters
// When to move slow: when the sliding window has duplicates
public class Q08_LongestSubstringWithoutDuplicates {
    public int longest(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int longest = 0;
        int slow = 0;

        // Treat this as a sliding window
        Set<Character> set = new HashSet<>();

        for (int fast = 0; fast < input.length(); fast++) {
            char ch = input.charAt(fast);
            while (set.contains(ch)) {
                set.remove(input.charAt(slow++));
            }
            set.add(ch);
            longest = Math.max(longest, fast - slow + 1);
        }
        return longest;
    }
}
