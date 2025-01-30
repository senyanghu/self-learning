package A_07_Graph_2_DFS;

import java.util.ArrayList;
import java.util.List;

public class Q04_CoinCombinations {
    public static int[] coins = {25, 10, 5, 1};

    public List<List<Integer>> coinCombinations(int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(target, res, combination, 0);
        return res;
    }

    private void dfs(int remaining, List<List<Integer>> res, List<Integer> combination, int index) {
        if (index == coins.length) {
            if (remaining == 0) {
                res.add(new ArrayList<>(combination));
            }
            return;
        }
        int limit = remaining / coins[index];
        for (int i = 0; i < limit; i++) {
            combination.add(coins[index]);
            dfs(remaining - i * coins[index], res, combination, index + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
