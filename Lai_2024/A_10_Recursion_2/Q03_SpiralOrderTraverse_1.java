package A_10_Recursion_2;

import java.util.ArrayList;
import java.util.List;


// feature 1: size - 2
// feature 2: shift + 1
public class Q03_SpiralOrderTraverse_1 {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        traverseHelper(matrix, matrix.length, 0, res);
        return res;
    }

    private void traverseHelper(int[][] matrix, int size, int shift, List<Integer> res) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            res.add(matrix[shift][shift]);
            return;
        }

        // TOP left to right
        for (int i = 0; i < size - 1; i++) {
            res.add(matrix[shift][i + shift]);
        }

        // TOP right to bottom right
        for (int i = 0; i < size - 1; i++) {
            res.add(matrix[shift + i][size - 1 - shift]);
        }

        // Bottom right to bottom left
        for (int i = 0; i < size - 1; i++) {
            res.add(matrix[size - 1 - shift][size - 1 - i]);
        }

        // Bottom left to top left
        for (int i = 0; i < size - 1; i++) {
            res.add(matrix[size - 1 - i][shift]);
        }

        traverseHelper(matrix, size - 2, shift + 1, res);
    }

    public static void main(String args[]) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Q03_SpiralOrderTraverse_1 soto = new Q03_SpiralOrderTraverse_1();
        List<Integer> res = soto.spiral(matrix);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
