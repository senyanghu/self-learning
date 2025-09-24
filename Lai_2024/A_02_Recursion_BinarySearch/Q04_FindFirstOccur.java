package A_02_Recursion_BinarySearch;

// binary search 两大诀窍
// (1) 每一次要把问题的scope narrow down
// (2) 在每一轮的迭代不能把 potential result 给误删
public class Q04_FindFirstOccur {
    public int firstOccurTemplate(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid; // right = mid - 1, wrong, this may pass correct result
            } else if (array[mid] < target) {
                left = mid; // left = mid + 1, this is also correct
            } else { // array[mid] > target
                right = mid; // right = mid - 1, this is also correct
            }
        }
        if (array[left] == target) {
            return left;
        }
        if (array[right] == target) {
            return right;
        }
        return -1;
    }
}
