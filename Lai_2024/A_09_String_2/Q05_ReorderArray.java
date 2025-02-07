package A_09_String_2;

// ABCDE12345 -> A1B2C3D4E5
// 0   1   2   3   4   5   6  |  7   8    9    0    1    2    3
// A   B   C   D   E   F   G  |  1   2    3    4    5    6    7
// L          LM                M             RM

// A   B   C   1   2   3  |  D   E   F   G    4    5    6    7
// L          M              LM               RM

// 解法精妙 有需求的话需要继续看孙老师的视频
public class Q05_ReorderArray {
    private void reorderHelper(char[] array, int left, int right) {
        int length = right - left + 1;
        if (length <= 2) {
            return;
        }

        int mid = left + length / 2;
        int leftmid = left + length / 4;
        int rightmid = left + length * 3 / 4;

        reverse(array, leftmid, mid - 1);
        reverse(array, mid, rightmid - 1);
        reverse(array, leftmid, rightmid - 1);

        reorderHelper(array, left, left + (leftmid - left) * 2 - 1);
        reorderHelper(array, left + (leftmid - left) * 2, right);
    }

    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String args[]) {
        char[] inputArray = { 'A', 'B', 'C', '1', '2', '3' };
        Q05_ReorderArray ra = new Q05_ReorderArray();
        ra.reorderHelper(inputArray, 0, 5);
        System.out.println(inputArray);
    }
}
