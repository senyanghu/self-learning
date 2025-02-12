package A_13_DP_2;

public class Q99_LargestSumSubarray {
    // base case: M[i] = array[i]
    // induction rule:
    // M[i] represents the largest sum of subarray ending with i-th number
    // M[i] = M[i - 1] + array[i]     if M[i - 1] >= 0
    //      = array[i]         	     otherwise
    public int largest(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int[] M = new int[nums.length];
        M[0] = nums[0];
        int largest = M[0];

        for (int i = 1; i < nums.length; i++) {
            if (M[i - 1] >= 0) {
                M[i] = M[i - 1] + nums[i];
            } else {
                M[i] = nums[i];
            }
            largest = Integer.max(largest, M[i]);
        }

        return largest;
    }

    public int largestWithSpaceOptimized(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int lastMax = nums[0];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            lastMax = Math.max(nums[i], lastMax + nums[i]);
            max = Integer.max(max, lastMax);
        }

        return max;
    }

    // when to update sol_left = left (when max is updated)
    // when to update sol_right = right (when max is updated)
    // when to update L (L = i when M[i - 1] < 0)
    // when to updaet R (update all the time each round)
    public int largestWithSpaceOptimizedWithLeftAndRightIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int lastMax = nums[0];
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        int sol_left = 0;
        int sol_right = 0;

        for (int i = 1; i < nums.length; i++) {
            if (lastMax >= 0) {
                lastMax = lastMax + nums[i];
                left = left;
                right = i;
            } else {
                lastMax = nums[i];
                left = i;
                right = i;
            }

            if (lastMax > max) {
                max = lastMax;
                sol_left = left;
                sol_right = right;
            }
        }

        System.out.println("sol_left is " + sol_left);
        System.out.println("sol_right is " + sol_right);

        return max;
    }

    public static void main(String args[]) {
        Q99_LargestSumSubarray lss = new Q99_LargestSumSubarray();
        int[] nums = {1, 2, 4, -1, -12, 10, -1};
        System.out.println(lss.largest(nums));
    }
}

