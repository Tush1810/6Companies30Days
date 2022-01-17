/*
    https://practice.geeksforgeeks.org/problems/longest-arithmetic-progression1019/1/#
*/

class Solution {
    private int[][] dp;
    int lengthOfLongestAP(int[] A, int n) {
        if (n == 1) return 1;
        dp = new int[n + 1][10000];
        int ans = 2, dif = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dif = A[j] - A[i];
                if (dp[i][dif] == 0) {
                    dp[j][dif] = 2;
                } else {
                    dp[j][dif] = 1 + dp[i][dif];
                }
                ans = Math.max(dp[j][dif], ans);
            }
        }
        return ans;
    }
}
