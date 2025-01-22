package A_02_Recursion;


// time complexity: O(2^n)
// space complexity: O(n) call stack的深度
//                     fib(n)
//                /           \
//          fib(n-1)        fib(n-2)
//         /        \       /        \
//   fib(n-2)  fib(n-3) fib(n-3)  fib(n-4)

public class Q01_Fibo {
    public long fibo(int k) {
        if (k < 0) {
            return 0;
        } else if (k <= 1) {
            return k;
        } else {
            return fibo(k - 1) + fibo(k - 2);
        }
    }
}
