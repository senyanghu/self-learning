package A_07_Graph_2_DFS;

import java.util.ArrayList;
import java.util.List;

public class Q03_GenParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfs(n, 0, 0, sb, res);
        return res;
    }

    private void dfs(int n, int left, int right, StringBuilder sb, List<String> res) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append('(');
            dfs(n, left + 1, right, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append(')');
            dfs(n, left, right + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Q03_GenParentheses g = new Q03_GenParentheses();
        System.out.println(g.generateParenthesis(2));
    }
}
