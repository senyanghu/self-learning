package A_加强练习1;

import java.util.ArrayList;
import java.util.List;

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
    public int[] findLargestAndSecondLargest(int[] array) {
        if (array == null || array.length < 2) {
            return new int[] { -1, -1 };
        }

        // 使用动态数组，避免未使用位置的问题
        List<Integer> winners = new ArrayList<>();
        List<Integer> losers = new ArrayList<>();

        // 第一轮：两两比较
        for (int i = 0; i < array.length / 2; i++) {
            if (array[2 * i] > array[2 * i + 1]) {
                winners.add(array[2 * i]);
                losers.add(array[2 * i + 1]);
            } else {
                winners.add(array[2 * i + 1]);
                losers.add(array[2 * i]);
            }
        }

        // 处理奇数长度
        if (array.length % 2 == 1) {
            winners.add(array[array.length - 1]);
            losers.add(array[array.length - 1]);
        }

        // 继续比较，找到最大值
        int max = findMax(winners);

        // 在最大值的"败者路径"中找第二最大值
        int secondMax = findSecondMax(losers, max);

        return new int[] { max, secondMax };
    }

    private int findMax(List<Integer> list) {
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    private int findSecondMax(List<Integer> losers, int max) {
        int secondMax = Integer.MIN_VALUE;
        for (int num : losers) {
            if (num != max && num > secondMax) {
                secondMax = num;
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
        Q08_LargestAndSecondLargest largestAndSecondLargest = new Q08_LargestAndSecondLargest();
        int[] array = { 1, 2, 4, 3, 6, 5, 8, 7 };
        int[] result = largestAndSecondLargest.findLargestAndSecondLargest(array);
        System.out.println("Largest: " + result[0] + ", Second Largest: " + result[1]);
    }
}
