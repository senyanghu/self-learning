package A_01_Array;

public class MoveZero {
    public void moveZeroToRight(int[] num) {
        int insertPosition = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0) {
                swap(num, insertPosition++, i);
            }
        }
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
        MoveZero moveZero = new MoveZero();
        int[] num = {0, 1, 0, 3, 12};
        moveZero.moveZeroToRight(num);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
