package A_06_Bit;

public class Q03_AllUniqueCharacters {
    public boolean allUnique(String word) {
        boolean[] used = new boolean[256];

        for (char c : word.toCharArray()) {
            if (used[c]) {
                return false;
            }
            used[c] = true;
        }
        return true;
    }

    // 假设都是26个小写字母组成的
    public boolean allUnique(char[] array) {
        int mask = 1;
        int dict = 0; // 000...000 (32个0)

        for (int i = 0; i < array.length; i++) {
            int offset = array[i] - 'a';
            int shift = mask << offset;
            if ((shift & dict) != 0) { // 说明之前这个char已经见过了
                return false;
            } else {
                dict = dict | shift;
            }
        }
        return true;
    }

    // 256 ASCII letters
    // 扩展到256 bit vector
    // int bit_map[8] // 8 * 32 = 256 bits
    public boolean allUniqueFollowup(char[] array) {
        int mask = 1;
        int[] dict = new int[8]; // 000...000

        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int row = current / 32;
            int col = current % 32;
            int shift = mask << col;
            if ((shift & dict[row]) != 0) { // 说明之前这个char已经见过了
                return false;
            } else {
                dict[row] = dict[row] | shift;
            }
        }
        return true;
    }
}
