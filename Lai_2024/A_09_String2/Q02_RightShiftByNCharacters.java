package A_09_String2;

// abcd ef
// W1   W2
// ef   abcd
// W2   W1
// 其实也是I love yahoo问题
// 反转单词 + 反转整个句子
public class Q02_RightShiftByNCharacters {
    public String rightShift(String input, int n) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] inputArray = input.toCharArray();

        int shift = n % inputArray.length;
        int length = input.length();

        // W1 should be [0, length - 1  - n]
        // W2 should be [length - n, length - 1]

        // step 1: reverse W1 and W2
        reverse(inputArray, 0, length - 1 - shift);
        reverse(inputArray, length - shift, length - 1);

        // step 2: reverse the whole
        reverse(inputArray, 0, length - 1);

        return new String(inputArray);
    }

    private void reverse(char[] inputArray, int start, int end) {
        while (start < end) {
            char temp = inputArray[start];
            inputArray[start] = inputArray[end];
            inputArray[end] = temp;
            start++;
            end--;
        }
    }
}
