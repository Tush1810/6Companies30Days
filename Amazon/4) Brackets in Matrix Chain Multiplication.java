/*
	https://practice.geeksforgeeks.org/problems/brackets-in-matrix-chain-multiplication1024/1/#
*/

class Solution {
	static String matrixChainOrder(int arr[], int n) {
		if (n == 3) {
			return "(AB)";
		}
		if (n == 2) return "A";
		int[][] dp = new int[n - 1][n - 1];
		int[][] directions = new int[n - 1][n - 1];
		for (int i = 0; i < n - 1; i++) {
			Arrays.fill(dp[i], -1);
		}

		int ans1, ans2;
		for (int i = 0; i < n - 1; i++) dp[i][i] = 0;

		int temp;
		for (int i = 1; i < n - 1; i++) {
			for (int j = 0; j < n - 1 && j + i < n - 1; j++) {
				dp[j][j + i] = Integer.MAX_VALUE;
				for (int k = j; k < j + i; k++) {
					temp = dp[j][k] + dp[k + 1][j + i] + arr[j] * arr[k + 1] * arr[j + i + 1];
					if (dp[j][j + i] > temp) {
						dp[j][j + i] = temp;
						directions[j][j + i] = k - j;
					}
				}
			}
		}
		return helper(dp, directions, 0, n - 2, 'A', (char)('A' + (n - 2)));
	}

	static String helper(int[][] dp, int[][] directions, int i, int j, char ii, char jj) {
		if (i > j) return "";
		if (i == j) return Character.toString(ii);
		if (i + 1 == j) {
			return "(" + String.valueOf(ii) + String.valueOf(jj) + ")";
		}
		int k = directions[i][j];
		return "(" + helper(dp, directions, i, i + k, ii, (char)(((int)ii) + k)) + helper(dp, directions, i + k + 1, j, (char)(((int)ii) + (k + 1)), jj) + ")";
	}
}
