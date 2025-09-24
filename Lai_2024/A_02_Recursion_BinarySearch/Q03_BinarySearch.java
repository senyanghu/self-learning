package A_02_Recursion_BinarySearch;

// binary search 两大诀窍
// (1) 每一次要把问题的scope narrow down
// (2) 在每一轮的迭代不能把potential result给误删
public class Q03_BinarySearch {
    public int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
