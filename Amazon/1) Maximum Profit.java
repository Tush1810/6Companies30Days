/*
	https://practice.geeksforgeeks.org/problems/maximum-profit4657/1
*/

class Solution {
	private static int[][][] dp;
	private static int n;
	public static int maxProfit(int k, int nn, int[] arr) {
		n = nn;
		dp = new int[n + 1][k + 1][2];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j <= k; j++) {
				dp[i][j][0] = -1;
				dp[i][j][1] = -1;
			}
		}
		return helper(arr, 0, k, false, 0);
	}

	public static int helper(int[] arr, int fee, int k, boolean owned, int start) {
		if (start == n) return 0;
		if (k == 0) return 0;
		if (owned && dp[start][k][0] != -1) return dp[start][k][0];
		if (!owned && dp[start][k][1] != -1) return dp[start][k][1];

		int ans1 = Integer.MIN_VALUE, ans2 = Integer.MIN_VALUE;
		if (!owned) {
			ans1 = helper(arr, fee, k, true, start + 1) - arr[start];
			ans1 = Math.max(ans1, helper(arr, fee, k, false, start + 1));
			dp[start][k][1] = ans1;
		} else {
			ans2 = helper(arr, fee, k - 1, false, start + 1) + arr[start] - fee;
			ans2 = Math.max(ans2, helper(arr, fee, k, true, start + 1));
			dp[start][k][0] = ans2;
		}
		return Math.max(ans1, ans2);
	}
}
