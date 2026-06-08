package A_加强练习1;

/**
 * Here's the text from the image:
 *
 * Q1.5.1 Given an array of random numbers, Push all the zero's of a given array to the end of the array.
 * For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}.
 * The order of all other elements can be changed.
 *
 * Expected time complexity is O(n) and extra space is O(1).
 */
public class Q05_Move0s {
    public int[] moveZero(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] == 0) {
                swap(array, left, right);
                right--;
            } else {
                left++;
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Q05_Move0s move0s = new Q05_Move0s();
        int[] array = { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0 };
        int[] result = move0s.moveZero(array);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
