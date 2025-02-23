package A_加强练习6_BinarySearch;

/*
Binary search

谁小删除谁
 */
public class Q01_FindKthSmallestFrom2Arrays {
    int findKthSmallest(int[] a, int aLeft, int[] b, int bLeft, int k) {
        if (aLeft >= a.length)
            return b[bLeft + k - 1];  // base case 1: if nothing left in a;
        if (bLeft >= b.length)
            return a[aLeft + k - 1];  // base case 2: if nothing left in b;
        if (k == 1)
            return Math.min(a[aLeft], b[bLeft]);  // base case 3

        // Since index is from 0, so the k/2-th element should be = left + k/2 - 1
        // why is it correct? if a.length too small, then remove elements from b first.
        int aHalfK = aLeft + k / 2 - 1 < a.length ? a[aLeft + k / 2 - 1] : Integer.MAX_VALUE;
        int bHalfK = bLeft + k / 2 - 1 < b.length ? b[bLeft + k / 2 - 1] : Integer.MAX_VALUE;

        if (aHalfK < bHalfK) {
            return findKthSmallest(a, aLeft + k / 2, b, bLeft, k - k / 2);
        } else {
            return findKthSmallest(a, aLeft, b, bLeft + k / 2, k - k / 2);
        }
    }
}
