package A_加强练习8_Trie;

import java.util.ArrayList;
import java.util.List;

/*
Given a matrix of characters, you can move from one cell to neighbor cell(up, down, left, right), on the same path, each cell can be used only once. Find all possible words that can be formed by a sequence of adjacent characters.
dictionary = {"at", "app", "apple", "cap", "cat", "cathy", "dog"}


A P P D
P P L G
O G E I
D K L M
output: {"app", "apple", "dog"}

DFS + Trie

Time Complexity:
M*N matrix, length of each word is l, size of dictionary is k

O (K * MN * 4^L)
 */
public class Q04_BoggleGame_BruteForce {
    int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<String> findWordsBruteForce(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(board, i, j, word, 0, rows, cols, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    // 这个boolean表示的是 从x y出发 下面有一个分支找到了匹配
    private boolean helper(char[][] board, int x, int y, String word, int index, int rows, int cols, boolean[][] visited) {
        // base case
        // 1. if all the characters are matched, we found a path representing the word
        if (index == word.length()) {
            return true;
        }

        // 2. think carefully about all the other terminate conditions
        //      a) out of bound
        //      b) already visited
        //      c) cannot match
        if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }

        // board[x][y] = word.charAt(index)
        visited[x][y] = true;
        for (int[] dir : DIRS) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if(helper(board, newX, newY, word, index + 1, rows, cols, visited)) {
                // 如果这个不写的话 那么visited找到的路径都被mark成true
                visited[newX][newY] = false;
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
}
