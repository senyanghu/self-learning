package A_10_Recursion_2;

// corner cases:
// 0^0
// denominator == 0
// data type conversion
public class Q99_Pow {
    public double power(int a, int b) {
        if (a == 0 && b == 0) {
            return 0;
        } else if (a == 0) {
            return 0;
        }
        if (b > 0) {
            return powerHelper(a, b);
        } else {
            return 1 / powerHelper(a, -b);
        }
    }

    // assume b >= 0
    public double powerHelper(int a, int b) {
        if (b == 0) {
            return 1;
        }
        double half = power(a, b / 2);
        return b % 2 == 0 ? half * half : a * half * half;
    }
}
