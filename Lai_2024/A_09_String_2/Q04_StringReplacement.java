package A_09_String_2;

// most hard-core method can be seen here: https://github.com/senyanghu/DaddyPlaypen/blob/master/src/com/laioffer/hw09/string_2/Q04_StringReplacement.java
public class Q04_StringReplacement {
    public String replace(String input, String s, String t) {
        if (input == null || input.length() == 0) {
            return input;
        }
        StringBuilder sb = new StringBuilder();
        int cursor = 0;

        while (cursor < input.length()) {
            if (cursor <= input.length() - t.length() && input.startsWith(s, cursor)) {
                sb.append(t);
                cursor += s.length();
            } else {
                sb.append(input.charAt(cursor));
                cursor += 1;
            }
        }
        return sb.toString();
    }
}
