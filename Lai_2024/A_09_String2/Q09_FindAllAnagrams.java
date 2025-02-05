package A_09_String2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q09_FindAllAnagrams {
    List<Integer> allAnagrams(String s, String l) {
        List<Integer> res = new ArrayList<>();
        if (s == null || l == null || s.length() == 0 || l.length() == 0) {
            return res;
        }

        // Create a Map to record the metadata of the short string, aka S.
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // How many kinds of letters we need to match
        int counter = map.size();
        int slow = 0; // indicates the left side of the sliding window

        for (int fast = 0; fast < l.length(); fast++) {
            char charToAdd = l.charAt(fast);
            if (fast < s.length()) { // sliding window is not FULL yet
                if (map.containsKey(charToAdd)) {
                    map.put(charToAdd, map.get(charToAdd) - 1);
                }
                if (map.get(charToAdd) == 0) {
                    counter--;
                }
                if (counter == 0) {
                    res.add(slow);
                }
            } else { // fast >= s.length(), we need to move left to ensure the size of window is appropriate
                char charToRemove = s.charAt(slow);
                if (map.containsKey(charToRemove) && map.get(charToRemove) == 0) {
                    counter++;
                }
                map.put(charToRemove, map.get(charToRemove) + 1);
                slow++;

                if (map.containsKey(charToAdd)) {
                    map.put(charToAdd, map.get(charToAdd) - 1);
                }
                if (map.get(charToAdd) == 0) {
                    counter--;
                }
                if (counter == 0) {
                    res.add(slow);
                }
            }
        }

        return res;
    }
}
