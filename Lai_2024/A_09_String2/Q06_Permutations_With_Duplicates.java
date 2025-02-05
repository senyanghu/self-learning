package A_09_String2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q06_Permutations_With_Duplicates {

    public List<String> permutations(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        char[] chars = set.toCharArray();
        dfs(chars, 0, res);
        return res;
    }

    private void dfs(char[] chars, int index, List<String> res) {
        if (index == chars.length) {
            res.add(new String(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        // 从index开始 这个题目最重要的地方
        for (int i = index; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                swap(chars, index, i);
                dfs(chars, index + 1, res);
                swap(chars, index, i);
            }
        }
    }

    private void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}
