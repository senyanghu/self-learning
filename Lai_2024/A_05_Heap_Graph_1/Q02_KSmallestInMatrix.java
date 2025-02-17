package A_05_Heap_Graph_1;

import Utils.Cell;

import java.util.PriorityQueue;

public class Q02_KSmallestInMatrix {
    public int KthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<Cell> pq = new PriorityQueue<>((c1, c2) -> {
            if (c1.value == c2.value) {
                return 0;
            }
            return c1.value - c2.value < 0 ? -1 : 1;
        });

        pq.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;

        for (int i = 0; i < k - 1; i++) {
            Cell cell = pq.poll();

            // check the bottom cell
            if (cell.row + 1 < row && !visited[cell.row + 1][cell.col]) {
                pq.offer(new Cell(cell.row + 1, cell.col, matrix[cell.row + 1][cell.col]));
                visited[cell.row + 1][cell.col] = true;
            }

            // check the right cell
            if (cell.col + 1 < col && !visited[cell.row][cell.col + 1]) {
                pq.offer(new Cell(cell.row, cell.col + 1, matrix[cell.row][cell.col + 1]));
                visited[cell.row][cell.col + 1] = true;
            }
        }
        return pq.peek().value;
    }
}
