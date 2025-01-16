package A_01_Array;

public class MergeSort {

    public int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        int[] helper = new int[array.length];
        MergeSort(array, helper, 0, array.length - 1);
        return array;
    }

    public void MergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        MergeSort(array, helper, left, mid);
        MergeSort(array, helper, mid + 1, right);

        combine(array, helper, left, mid, right);
    }

    public void combine(int[] array, int[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        int currentIndex = left;
        while (leftIndex <= mid && rightIndex <= right) {
            if (helper[leftIndex] < helper[rightIndex]) {
                array[currentIndex] = helper[leftIndex];
                leftIndex++;
            } else {
                array[currentIndex] = helper[rightIndex];
                rightIndex++;
            }
            currentIndex++;
        }
        while (leftIndex <= mid) {
            array[currentIndex] = helper[leftIndex];
            leftIndex++;
            currentIndex++;
        }
        // Note: We don't need to copy remaining elements from right half
        // as they are already in their correct positions
    }

    public static void main(String args[]) {
        MergeSort ms = new MergeSort();
        int[] array = {3, -1, -10, -9};
        int[] result = ms.mergeSort(array);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

