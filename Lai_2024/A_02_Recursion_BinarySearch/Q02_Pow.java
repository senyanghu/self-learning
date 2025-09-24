package A_02_Recursion_BinarySearch;

public class Q02_Pow {
    // assume a != 0, b >= 0
    // log(b) levels in call stack
    // time complexity: O(log(b))
    // space complexity: O(log(b))
    public long power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        long half = power(a, b / 2);
        if (b % 2 == 1) {
            return a * half * half;
        } else {
            return half * half;
        }
    }

    // LC solution
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / power(x, -n);
        } else {
            return power(x, n);
        }
    }

    public double power(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double half = power(x, n / 2);

        return (n % 2 == 0) ? half * half : half * half * x;
    }
}
