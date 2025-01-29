package A_06_Bit;

// how to reverse all bits of a number
// 11100 -> 00111
// xxxxx 0 xxxxxxxxxxx 1 xxxxx
//       i             j
// 00000 1 00000000000 1 00000  "XOR"
// case1: bit[i] == bit[j] do nothing
// case2: bit[i] != bit[j] flip respectively
public class Q05_ReverseBits {
    public int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            n = swapBits(n, i, 32 - i - 1);
        }
        return n;
    }

    public int swapBits(int n, int i, int j) {
        // 分别把i和j位置上面的bit给取出来
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;

        if ((a ^ b) == 1) { // 异或等于1 那么说明a和b不一样 需要交换
            // ((1 << i) | (1 << j)) -> 00000 1 00000000000 1 00000
            n ^= ((1 << i) | (1 << j));
        }

        return n;
    }
}
