package A_02_Recursion_BinarySearch;

public class Q06_ClosestToTarget {
    public int closestToTarget(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (Math.abs(target - nums[start]) < Math.abs(target - nums[end])) {
            return start;
        } else {
            return end;
        }
    }
}
