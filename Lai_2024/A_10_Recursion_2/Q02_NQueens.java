package A_10_Recursion_2;


import java.util.ArrayList;
import java.util.List;

// base rule: last row is done, and 0 row left
// recursive rule: if position(i, j) is valid, go to the next level (i + 1)
public class Q02_NQueens {
    public List<List<Integer>> nqueen(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        List<Integer> sequence = new ArrayList<>();
        dfs(res, sequence, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> sequence, int n) {
        if (sequence.size() == n) {
            res.add(new ArrayList<>(sequence));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(sequence, i)) {
                sequence.add(i);
                dfs(res, sequence, n);
                sequence.remove(sequence.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> sequence, int index) {
        int currentSequenceSize = sequence.size();

        for (int i = 0; i < currentSequenceSize; i++) {
            if (sequence.get(i) == index) {
                return false;
            }
            if (currentSequenceSize - i == Math.abs(sequence.get(i) - index)) {
                return false;
            }
        }

        return true;
    }
}
