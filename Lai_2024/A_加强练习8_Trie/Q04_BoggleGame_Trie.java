package A_加强练习8_Trie;

import Utils.TrieNode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity:
// M*N matrix, length of each word is l, size of dictionary is k
// O (mn * 4^l)
public class Q04_BoggleGame_Trie {
    int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Sol2: trie tree + dfs backtracking
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        // sanity check
        if (board == null || board.length == 0 || board[0].length == 0 || words == null
                || words.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }
        // step one --> build the Trie from the given list of words.
        // TrieNode root = buildDict(words);
        TrieNode root = new TrieNode();
        final int rows = board.length;
        final int cols = board[0].length;
        StringBuilder sb = new StringBuilder();
        // from every cell try to find the word corresponding to the part start from the current cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(root, board, i, j, sb, res);
            }
        }
        return res;
    }

    private void dfs(TrieNode root, char[][] board, int x, int y, StringBuilder sb, List<String> res) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        char ch = board[x][y];
        // if the current cell has been consumed by previous character, or the dict has no more characters
        // can match the current path, we should return
        if (ch == '#' || root.children.get(ch) == null) {
            return;
        }

        root = root.children.get(ch);
        sb.append(ch);
        if (root.isWord) {
            res.add(sb.toString());
            root.isWord = false;
        }

        board[x][y] = '#';
        for (int[] dir : DIRS) {
            int neiX = dir[0] + x;
            int neiY = dir[1] + y;
            dfs(root, board, neiX, neiY, sb, res);
        }
        board[x][y] = ch;
    }
}
