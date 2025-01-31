package A_08_Hash_And_String_1;

public class Q04_RemoveAdjacentRepeatedCharactersI {
    /**
     * remove adjacent, repeated characters in a given string, leaving only one
     * character for each group of such characters
     * <p>
     * <p>
     * aaaabbbbbc -> abc
     */
    // slow: all letters to the left hand side of input are the results to return
    // (including slow)
    // fast: current index
    public String deDup(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        // [0, left] is the answer
        int slow = 0;
        char[] arrayInput = input.toCharArray();
        for (int i = 1; i < arrayInput.length; i++) {
            if (arrayInput[slow] != arrayInput[i]) {
                slow++;
                arrayInput[slow] = arrayInput[i];
            }
        }

        return new String(arrayInput, 0, slow + 1);
    }

    public static void main(String args[]) {
        Q04_RemoveAdjacentRepeatedCharactersI rad = new Q04_RemoveAdjacentRepeatedCharactersI();
        String input = "aaaabbbbbaaaac";
        System.out.println(rad.deDup(input));
    }
}
