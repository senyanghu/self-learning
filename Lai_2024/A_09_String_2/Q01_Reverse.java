package A_09_String_2;

public class Q01_Reverse {
    public String reverse(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }

        char[] inputArray = input.toCharArray();
        reverseHelper(inputArray, 0, input.length() - 1);
        return new String(inputArray);
    }

    private void reverseHelper(char[] inputArray, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(inputArray, left, right);
        reverseHelper(inputArray, left + 1, right - 1);
    }

    private void swap(char[] inputArray, int left, int right) {
        char temp = inputArray[left];
        inputArray[left] = inputArray[right];
        inputArray[right] = temp;
    }

    public static void main(String[] args) {
        Q01_Reverse obj = new Q01_Reverse();
        System.out.println(obj.reverse("apple"));
    }
}
