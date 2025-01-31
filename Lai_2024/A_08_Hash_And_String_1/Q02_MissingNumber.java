package A_08_Hash_And_String_1;

public class Q02_MissingNumber {
    public int missing(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int n = array.length + 1;
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        for (int num : array) {
            xor ^= num;
        }
        return xor;
    }
}
