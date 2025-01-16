package A_01_Array;

public class QuickSort {
    public int[] quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        quickSortHelper(array, 0, array.length - 1);
        return array;
    }

    private void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }


        int pivotPosition = partition(array, left, right);
        quickSortHelper(array, left, pivotPosition - 1);
        quickSortHelper(array, pivotPosition + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        // Choose a random pivot to avoid worst case in sorted arrays
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        int pivot = array[pivotIndex];

        // Move pivot to the rightmost position
        swap(array, pivotIndex, right);

        int leftBound = left;
        // [0, leftBound) are < than pivot
        for (int i = left; i < right; i++) {
            if (array[i] < pivot) {
                swap(array, i, leftBound);
                leftBound++;
            }
        }
        swap(array, leftBound, right);
        return leftBound;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String args[]) {
        QuickSort qs = new QuickSort();
        int[] input = { 3, 1, 1, -2, -3 , -1 };
        qs.quickSort(input);
        for (int i : input) {
            System.out.print(i + " ");
        }
    }
}
