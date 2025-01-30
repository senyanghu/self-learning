package A_07_Graph_2_DFS;

import java.util.ArrayList;
import java.util.List;

// DFS 基本方法
// 1. what does it store on each level (每层代表什么意义？解体之前就需要知道DFS需要recurse多少层)
// 2. How many different states should we try to put on this level? (每层有多少个状态需要try)
public class Q01_Subsets {
    public List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        if (set == null || set.length() == 0) {
            return res;
        }
        dfs(set, 0, new StringBuilder(), res);
        return res;
    }

    private void dfs(String set, int index, StringBuilder sb, List<String> res) {
        if (index == set.length()) {
            res.add(sb.toString());
            return;
        }

        // 两种状态
        // State 1: choose the 'letter' at current level
        sb.append(set.charAt(index));
        dfs(set, index + 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);

        // State 2: does NOT choose the 'letter' at the current level
        dfs(set, index + 1, sb, res);
    }
}
