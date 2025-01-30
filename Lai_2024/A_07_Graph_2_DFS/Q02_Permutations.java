package A_07_Graph_2_DFS;

import java.util.ArrayList;
import java.util.List;

public class Q02_Permutations {
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
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            dfs(chars, index + 1, res);
            swap(chars, index, i);
        }
    }

    private void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    public static void main(String args[]) {
        Q02_Permutations sol = new Q02_Permutations();
        System.out.println(sol.permutations("abcd"));
    }
}
