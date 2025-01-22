package A_02_Recursion_BinarySearch;

public class Q07_KClosest {
    public int[] kClosest(int[] arr, int target, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }
        // 1. 先用二分查找找到最接近target的位置
        int left = largestSmallerEqual(arr, target);
        int right = left + 1;

        // 2. 用双指针向两边扩展，找到k个最近的数
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if ((right >= arr.length) || (left >= 0 && target - arr[left] <= arr[right] - target)) {
                result[i] = arr[left--];
            } else {
                result[i] = arr[right++];
            }
        }
        return result;
    }

    // 找到小于等于target的最大索引
    private int largestSmallerEqual(int[] input, int target) {
        int start = 0;
        int end = input.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (input[mid] == target) {
                start = mid;
            } else if (input[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (input[end] <= target) {
            return end;
        }
        if (input[start] <= target) {
            return start;
        }

        return -1;
    }
}
