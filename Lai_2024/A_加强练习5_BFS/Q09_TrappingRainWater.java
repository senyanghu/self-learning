package A_加强练习5_BFS;

// https://www.geeksforgeeks.org/trapping-rain-water/

public class Q09_TrappingRainWater {
    // 中心开花的方法 O(n^2)
    public int maxWater(int[] arr) {
        int res = 0;

        // For every element of the array
        for (int i = 1; i < arr.length - 1; i++) {

            // Find the maximum element on its left
            int left = arr[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }

            // Find the maximum element on its right
            int right = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                right = Math.max(right, arr[j]);
            }

            // Update the maximum water
            res += Math.min(left, right) - arr[i];
        }

        return res;
    }

    /*
    DP
    Left[i] represents the highest value from 0-th to i-th element (including the i-th element)
    Right[i] represents the highest value from i-th element to 0-th element (including the i-th element)
     */
    public int maxWaterUsingDP(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        // Populate the value for left
        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        // Populate the value for right
        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int water = Math.min(left[i], right[i]) - arr[i];
            res += water;
        }
        return res;
    }
}
