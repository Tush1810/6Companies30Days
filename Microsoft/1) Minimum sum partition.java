/*
    https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1/#
*/

class Solution {
    private boolean[][] dp;
    private int ans, originalSum;
    public int minDifference(int arr[], int n) {
        ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        originalSum = sum;
        dp = new boolean[n + 1][2 * sum + 1];

        helper(arr, n, sum, 0);
        return ans;
    }

    private void helper(int[] arr, int n, int sum, int start) {
        if (start == n) return;
        if (dp[start][originalSum + sum]) return;

        if (Math.abs(sum) < ans) {
            ans = Math.abs(sum);
        }

        if (sum < 0) return;

        helper(arr, n, sum, start + 1);
        helper(arr, n, sum - 2 * arr[start], start + 1);
        dp[start][originalSum + sum] = true;
    }
}
