/*
    https://leetcode.com/problems/split-array-largest-sum/submissions/
*/

class Solution {
    int[] prefix;
    int[][] dp;
    public int splitArray(int[] nums, int m) {
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        dp = new int[nums.length + 1][m + 1];
        for (int i = 1; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
            prefix[i] = prefix[i - 1] + nums[i];
        }
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[nums.length], -1);
        return helper(0, m, nums);
    }
    private int helper(int pos, int m, int[] arr) {
        if (m == 0 && pos == arr.length) {
            return -2;
        } else if (m == 0) return -1;
        if (dp[pos][m] != -1) return dp[pos][m];
        int temp = -1, minSum = Integer.MAX_VALUE, largestSum = -1;
        for (int i = pos; i <= arr.length - m; i++) {
            if (pos == 0)
                largestSum = prefix[i];
            else largestSum = prefix[i] - prefix[pos - 1];
            temp = helper(i + 1, m - 1, arr);
            if (temp == -1) {
                continue;
            } else if (temp == -2) {
                minSum = Math.min(minSum, largestSum);
            } else minSum = Math.min(minSum, Math.max(largestSum, temp));
        }
        return dp[pos][m] = minSum;
    }
}
