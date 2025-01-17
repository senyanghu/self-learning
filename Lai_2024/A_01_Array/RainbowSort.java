package A_01_Array;

public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        rainbowSortHelper(array, 0, 0, array.length - 1);
        return array;
    }

    /**
     * @param array the input array
     * @param left  [0. left) should be all -1
     * @param cur   current cursor, [left, cursor) all 0
     * @param right (right, length - 1] should be all 1
     *              <p>
     *              [cursor, right] 未知区域
     */
    private void rainbowSortHelper(int[] array, int left, int cur, int right) {
        while (cur <= right) {
            if (array[cur] == -1) {
                swap(array, left++, cur++);
            } else if (array[cur] == 0) {
                cur++;
            } else { // array[cur] == 1
                swap(array, cur, right--);
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String args[]) {
        RainbowSort rss = new RainbowSort();
        //int[] array = { 0, -1, 1, 1, -1, 0, -1 };
        int[] array = {-1, -1, -1, -1, -1};
        rss.rainbowSort(array);
        for (int element : array) {
            System.out.println(element);
        }
    }
}
