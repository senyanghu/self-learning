package A_08_Hash_And_String_1;

import java.util.Stack;

/**
 * Repeatedly remove all adjacent, repeated characters in a ginve string from
 * left to right
 * <p>
 * abbbbaaccz -> aaaccz -> ccz -> z
 */
public class Q08_RemoveAdjacentRepeatedCharactersIV {
    public String deDup(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }

        int fast = 0;
        char[] inputArray = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        while (fast < input.length()) {
            char current = inputArray[fast];
            if (stack.size() > 0 && current == stack.peek()) {
                while (fast < input.length() && inputArray[fast] == stack.peek()) {
                    fast++;
                }
                stack.pop();
            } else {
                stack.push(current);
                fast++;
            }
        }
        char[] res = new char[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return new String(res);
    }
}