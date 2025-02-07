package A_09_String_2;

// aaaabccaaaaa -> a4b1c2a5
// AAAAaaaa -> A4a4
// (1) Deal with the cases where adjacent occurrence of letters >= 2. In the meantime, we need to record of time
// of the letter == 1
// (2) Deal with cases where the adjacent occurrence of the letters == 1
// (3) Finalize the string by calling resize()


// aaaabccaaaaa -> a4bc2a5
// a4bc2a5 -> a4b1c2a5
public class Q07_EncodeString1 {
    public static String encode(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        StringBuilder sb = new StringBuilder();
        char ch = input.charAt(0);
        int count = 1;
        int fast = 1;
        while (fast < input.length()) {
            if (ch == input.charAt(fast)) {
                count++;
            } else {
                sb.append(ch);
                sb.append(count);
                ch = input.charAt(fast);
                count = 1;
            }
            fast++;
        }
        sb.append(ch);
        sb.append(count);
        return sb.toString();
    }

    public static void main(String args[]) {
        System.out.println(encode("aaaabccaaaaa"));
    }
}
