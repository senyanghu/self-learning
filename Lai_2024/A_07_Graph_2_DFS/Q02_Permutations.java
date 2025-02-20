package A_07_Graph_2_DFS;

import java.util.ArrayList;
import java.util.List;

/*
p0 p1 p2
x  x  x

input = a b c

L0 (position0)        a(bc)          b(ac)          c(ab)
                     /     \        /     \        /     \
L1                b(c)    c(b)    a(c)   c(a)    a(b)   b(a)
                   |       |        |      |       |      |
L2                 c       b        c      a       b      a


Time = O(n!)
 */
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
        // 从index开始 这个题目最重要的地方
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
