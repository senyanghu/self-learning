package A_06_Bit;

public class Q02_DiffBits {
    public int diffBits(int a, int b) {
        int xor = a ^ b;
        int count = 0;

        // 处理所有32位，包括符号位
        for (int i = 0; i < 32; i++) {
            count += (xor >>> i) & 1;
        }

        return count;

        // 或者使用while循环
    /*
    while (xor != 0) {
        count += xor & 1;
        xor = xor >>> 1;
    }
    return count;
    */
    }
}

/**
 *
 * 为什么要用 >>>：
 *
 * >> 是算术右移，保持符号位
 *
 * 对负数右移时，最高位补1
 * 可能导致死循环
 *
 *
 * >>> 是逻辑右移
 *
 * 最高位总是补0
 * 保证能处理所有32位
 */
