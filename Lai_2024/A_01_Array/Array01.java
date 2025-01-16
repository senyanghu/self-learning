package A_01_Array;

public class Array01 {

    public void printArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Array01 array01 = new Array01();
        array01.printArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }
}
