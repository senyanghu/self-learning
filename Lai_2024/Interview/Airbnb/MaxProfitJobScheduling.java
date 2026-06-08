package Interview.Airbnb;

class MaxProfitJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        if (n == 0) {
            return 0;
        }

        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        java.util.Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            ends[i] = jobs[i][1];
        }

        // dp[i] means the max profit that you could get with ith job (1-indexed)
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int start = jobs[i - 1][0];
            int curProfit = jobs[i - 1][2];

            int k = findLastNonConflict(ends, i - 1, start);

            int take = dp[k] + curProfit;
            int skip = dp[i - 1];
            dp[i] = Math.max(take, skip);
        }
        return dp[n];
    }

    public int findLastNonConflict(int[] array, int rightBound, int target) {
        // search in array[0..rightBound-1] (inclusive) for the last index with value <= target
        // return dp index = foundIndex + 1; if not found, return 0
        if (array == null || rightBound <= 0) {
            return 0;
        }
        int l = 0, r = rightBound - 1, ans = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (array[m] <= target) {
                ans = m + 1;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime   = {3, 4, 5, 6};
        int[] profit    = {50, 10, 40, 70};
        MaxProfitJobScheduling solver = new MaxProfitJobScheduling();
        int ans = solver.jobScheduling(startTime, endTime, profit);
        System.out.println(ans); // expected 120
    }
}
