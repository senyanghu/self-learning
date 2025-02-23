package A_加强练习4_DFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
The text in the image reads:

"void DFS(
    int[] brace,
    int[] bracket,
    int[] parenthesis,
    Deque<Character> stack, List<Character> cur, List<List<Character>> res)

1st element means input=3
2nd element means left { added so far
3rd element means right } added so far
                        3  0  0
// 3 elements [0] [1] [2]
// 3 elements [0] [1] [2]
// 3 elements [0] [1] [2]

Or use int[][].

Solution details:
    Case 1: Whenever we add one kind of left parenthesis, as long as we have left parenthesis remaining,
            we add this left parenthesis to the path_prefix, and push to the stack.
    Case 2: Whenever we add a right parenthesis, we first check whether you have right parenthesis remaining,
            and check whether it matches the top of the stack.
        Case 2.1: if matches, stack.pop() AND path_prefix.add(right parenthesis)
        Case 2.2: If not match, then prune this branch (NOT calling the recursion function)"
 */
public class Q08_GenParenthesesProMax {
    private static final char[] parenthese = new char[]{'(', ')', '[', ']', '{', '}'};

    public List<String> validParentheses(int l, int m, int n) {
        // Write your solution here.
        List<String> result = new ArrayList<>();
        int length = 2 * (l + m + n);
        int[] remain = new int[]{l, l, m, m, n, n};
        Deque<Character> stack = new LinkedList<>();
        StringBuilder cur = new StringBuilder();
        permutationHelper(remain, length, stack, cur, result);
        return result;
    }

    private void permutationHelper(int[] remain, int length, Deque<Character> stack, StringBuilder cur,
                                   List<String> result) {
        if (cur.length() == length) {
            result.add(cur.toString());
            return;
        }

        for (int i = 0; i < remain.length; i++) {
            if (i % 2 == 0) {
                if (remain[i] > 0) {
                    cur.append(parenthese[i]);
                    stack.offerFirst(parenthese[i]);
                    remain[i]--;
                    permutationHelper(remain, length, stack, cur, result);
                    cur.deleteCharAt(cur.length() - 1);
                    stack.pollFirst();
                    remain[i]++;
                }
            } else {
                if (!stack.isEmpty() && stack.peekFirst() == parenthese[i - 1]) {
                    cur.append(parenthese[i]);
                    stack.pollFirst();
                    remain[i]--;
                    permutationHelper(remain, length, stack, cur, result);
                    cur.deleteCharAt(cur.length() - 1);
                    stack.offerFirst(parenthese[i - 1]);
                    remain[i]++;
                }
            }
        }
    }
}
