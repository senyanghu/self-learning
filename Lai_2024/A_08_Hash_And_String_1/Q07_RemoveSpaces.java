package A_08_Hash_And_String_1;

// Given a string, remove all leading/trailing/duplicated empty spaces
// "____abc__de___f_____"
// "abc_de_f"
// i: slow all letter to the left-hand side of i are the results to return
// j: fast current index

// (1) for all non-space, copy all non-space (words)
// (2) for all space, only copy 1 empty space before each word (except the first word)
// 一个word前面都要加一个空格(除了第一个)
public class Q07_RemoveSpaces {
    public String removeSpaces(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        int slow = 0;
        int fast = 0;
        int wordCount = 0;
        char[] inputChar = input.toCharArray();

        while (true) {
            // skip all leading white spaces in front of each word
            while (fast < input.length() && input.charAt(fast) == ' ') {
                fast++;
            }
            if (fast == input.length()) {
                break;
            }
            if (wordCount > 0) {
                inputChar[slow++] = ' ';
            }
            while (fast < input.length() && input.charAt(fast) != ' ') {
                inputChar[slow++] = input.charAt(fast++);
            }
            wordCount++;
        }

        return new String(inputChar, 0, slow);
    }
}
