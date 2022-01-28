/*
    https://docs.google.com/document/d/1XsyXdufDAK1C6PbC0KNeO95ydbH8qlsGnkyThkS-1bs/edit
*/

class Solution {
    private int[][] dp;
    public int getMoneyAmount(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        helper(1, n);
        return dp[1][n];
    }

    private int helper(int start, int end) {
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        if (start == end) {
            return 0;
        }
        if (start == end - 1) {
            return start;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = start + 1; i <= end - 1; i++) {
            ans = Math.min(Math.max(helper(start, i - 1), helper(i + 1, end)) + i, ans);
        }
        return dp[start][end] = ans;
    }
}
