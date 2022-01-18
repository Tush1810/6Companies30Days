/*
    https://practice.geeksforgeeks.org/problems/pots-of-gold-game/1/#
*/

class GfG {
  private static int[][][] dp;
  public static int maxCoins(int arr[], int n) {
    dp = new int[n + 1][n + 1][2];
    for (int i = 0; i < n; i++) {
      dp[i][i][0] = arr[i];
      dp[i][i][1] = 0;
    }
    for (int length = 1; length < n; length++) {
      for (int i = 0; i + length < n; i++) {
        if (dp[i][i + length - 1][1] + arr[i + length] > dp[i + 1][i + length][1] + arr[i]) {
          dp[i][i + length][0] = dp[i][i + length - 1][1] + arr[i + length];
          dp[i][i + length][1] = dp[i][i + length - 1][0];
        } else {
          dp[i][i + length][0] = dp[i + 1][i + length][1] + arr[i];
          dp[i][i + length][1] = dp[i + 1][i + length][0];
        }
      }
    }

    return dp[0][n - 1][0];
  }
}
