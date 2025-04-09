package Meta;

/*
https://github.com/doocs/leetcode/blob/main/solution/0400-0499/0408.Valid%20Word%20Abbreviation/README_EN.md
 */
public class Q01_Valid_Word_Abbr {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordPtr = 0;
        int abbrPtr = 0;

        while (wordPtr < word.length() && abbrPtr < abbr.length()) {
            // If current abbreviation character is a letter
            if (Character.isLetter(abbr.charAt(abbrPtr))) {
                // Letters must match exactly
                if (abbr.charAt(abbrPtr) != word.charAt(wordPtr)) {
                    return false;
                }
                wordPtr++;
                abbrPtr++;
            }

            // If current abbreviation character is a digit
            else {
                // Check for leading zero
                if (abbr.charAt(abbrPtr) == '0') {
                    return false;
                }
                // Calculate the number of skipped characters
                int num = 0;
                while (abbrPtr < abbr.length() && Character.isDigit(abbr.charAt(abbrPtr))) {
                    num = num * 10 + (abbr.charAt(abbrPtr) - '0');
                    abbrPtr++;
                }
                // Skip the specified number of characters in word
                wordPtr += num;
            }
        }
        // Both pointers must reach the end of their respective strings
        return wordPtr == word.length() && abbrPtr == abbr.length();
    }
}

