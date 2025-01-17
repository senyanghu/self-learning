package A_01_Array;

public class MoveZero {
    public void moveZeroToRight(int[] nums) {
        int insertPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, insertPosition++, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        MoveZero moveZero = new MoveZero();
        int[] nums = {0, 1, 0, 3, 12};
        moveZero.moveZeroToRight(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
