package A_06_Bit;

public class Q01_IsPowerOfTwo {
    public boolean isPowerOfTwo(int number) {
        // 一个数是2的幂，当且仅当：
        // 1. 大于0
        // 2. 二进制表示中只有一个1
        return number > 0 && (number & (number - 1)) == 0;
    }
}

/**
 * 1 = 1
 * 2 = 10
 * 4 = 100
 * 8 = 1000
 * 16 = 10000
 * <p>
 * 以16为例：
 * 16     = 10000
 * 16 - 1 = 01111
 * 16 & 15 = 00000  // 结果为0
 * <p>
 * 以18为例（不是2的幂）：
 * 18     = 10010
 * 18 - 1 = 10001
 * 18 & 17 = 10000  // 结果不为0
 */
