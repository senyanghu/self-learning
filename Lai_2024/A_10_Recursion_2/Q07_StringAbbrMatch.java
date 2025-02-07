package A_10_Recursion_2;

public class Q07_StringAbbrMatch {
    private boolean isDigit(char input) {
        return input >= '0' && input <= '9';
    }

    public boolean match(String input, String pattern) {
        if (input.length() == 0 && pattern.length() == 0) {
            return true;
        } else if (input.length() == 0 || pattern.length() == 0) {
            return false;
        }

        if (isDigit(pattern.charAt(0))) { // case 1: S2.at(0) is a digit
            int i = 0;
            int num = 0;
            while (i < pattern.length() && isDigit(pattern.charAt(i))) {
                num = num * 10 + pattern.charAt(i) - '0';
                i++;
            }
            if (num > input.length()) {
                return false;
            } else {
                return match(input.substring(num), pattern.substring(i));
            }
        } else { // case 2: S2.at(0) is not a digit
            if (input.charAt(0) != pattern.charAt(0)) {
                return false;
            } else {
                return match(input.substring(1), pattern.substring(1));
            }
        }
    }
}
