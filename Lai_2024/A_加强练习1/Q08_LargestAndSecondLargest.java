package A_加强练习1;

/**
 * Here's the text from the image:
 *
 * Q2.2 How to use the least number of comparisons to find the largest and second largest number?
 *
 * Primitive idea: 2n
 * bottom line: 1n
 * 1n ← 2n
 *
 * Solution:
 * 3 2    1 4    5 7    2 8
 * 3 [2]  4 [1]  7 [5]  8 [2]    n/2
 *     4 [1, 3]     8 [2, 7]     n/4
 *         8 [2, 7, 4]           n/8
 *
 * n comparisons to find the largest
 * log(n) comparisons to find the second largest
 *
 * Total # = n + log(n)
 */
public class Q08_LargestAndSecondLargest {
}
