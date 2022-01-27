/*
    https://leetcode.com/problems/stone-game/
*/

class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n + 1][n + 1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
            sum += piles[i];
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = Math.max(piles[i], piles[i + 1]);
        }

        for (int length = 2; length < n; length++) {
            for (int i = 0; i + length < n; i++) {
                dp[i][i + length] = Math.max(piles[i] + Math.min(dp[i + 1][i + length - 1], dp[i + 2][i + length]), piles[i + length] + Math.min(dp[i + 1][i + length - 1], dp[i][i + length - 2]));
            }
        }
        if (sum - dp[0][n - 1] > dp[0][n - 1]) {
            return false;
        }
        return true;
    }
}
