package MongoDB;

import java.util.HashSet;

public class Q08_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // Set for checking duplicates
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                // Skip empty cells
                if (current == '.') {
                    continue;
                }

                // Try to add current value to each of the three check formats
                // Format: "value in row i"
                if (!seen.add(current + " in row " + i)) {
                    return false;
                }

                // Format: "value in column j"
                if (!seen.add(current + " in column " + j)) {
                    return false;
                }

                // Format: "value in box (i/3, j/3)"
                // Integer division gives us the box coordinates (0,0), (0,1), etc.
                if (!seen.add(current + " in box " + i / 3 + "," + j / 3)) {
                    return false;
                }
            }
        }

        return true;
    }
}
