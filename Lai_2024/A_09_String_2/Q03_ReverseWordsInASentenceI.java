package A_09_String_2;

// step1: swap the whole sentence
// step2: swap every single word (two pointer)

public class Q03_ReverseWordsInASentenceI {
    public String reverseWords(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }

        // 1. 反转整个句子
        char[] chars = input.toCharArray();
        reverseString(chars, 0, chars.length - 1);

        // 2. 反转每个单词
        int start = 0;
        for (int i = 0; i <= chars.length; i++) {
            // 本质上就是要找空格 找到空格以后 空格的前面一个位置就是上一个单词的尾巴
            if (i == chars.length || chars[i] == ' ') {
                reverseString(chars, start, i - 1);
                start = i + 1;
            }
        }

        return new String(chars);
    }

    private void reverseString(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}
