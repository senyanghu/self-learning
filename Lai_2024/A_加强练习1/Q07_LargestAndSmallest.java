package A_加强练习1;

import java.util.Arrays;

/**
 * Q2.1 Use the least number of comparisons to find the largest and smallest number.
 * 1 2 4 3 6 5 8 7
 */

// 思路是先两两比较 然后分成“胜者组”和“败者组”
// 最大的肯定是出现在胜者组
// 最小的肯定是出现在败者组
public class Q07_LargestAndSmallest {
    public int[] findLargestAndSmallest(int[] array) {
        if (array == null || array.length == 0) {
            return new int[] { -1, -1 };
        }

        int n = array.length;
        int[] winners = new int[n / 2];
        int[] losers = new int[n / 2];

        // 第一步：两两比较，分组
        for (int i = 0; i < n / 2; i++) {
            if (array[2 * i] > array[2 * i + 1]) {
                winners[i] = array[2 * i];
                losers[i] = array[2 * i + 1];
            } else {
                winners[i] = array[2 * i + 1];
                losers[i] = array[2 * i];
            }
        }

        // 处理奇数长度的情况
        if (n % 2 == 1) {
            winners = Arrays.copyOf(winners, winners.length + 1);
            losers = Arrays.copyOf(losers, losers.length + 1);
            winners[winners.length - 1] = array[n - 1];
            losers[losers.length - 1] = array[n - 1];
        }

        // 第二步：在胜者组中找最大值
        int max = winners[0];
        for (int i = 1; i < winners.length; i++) {
            if (winners[i] > max) {
                max = winners[i];
            }
        }

        // 第三步：在败者组中找最小值
        int min = losers[0];
        for (int i = 1; i < losers.length; i++) {
            if (losers[i] < min) {
                min = losers[i];
            }
        }

        return new int[] { max, min };
    }

    public static void main(String[] args) {
        Q07_LargestAndSmallest largestAndSmallest = new Q07_LargestAndSmallest();
        int[] array = { 1, 2, 4, 3, 6, 5, 8, 7 };
        int[] result = largestAndSmallest.findLargestAndSmallest(array);
        System.out.println("Largest: " + result[0] + ", Smallest: " + result[1]);
    }
}
