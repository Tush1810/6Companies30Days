/*
    https://practice.geeksforgeeks.org/problems/7b9d245852bd8caf8a27d6d3961429f0a2b245f1/1/#
*/

class Solution {
    int mod = 1_000_000_007;
    public int kvowelwords(int n, int k) {
        long ans;
        if (n == 0) return 0;
        if (k == 0) return fastPow(21, n, mod);
        long[][] dp = new long[n + 1][k + 1];

        int sum = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = modMul(sum, 21, mod);
            sum = (int)dp[i][0];
            for (int j = 1; j <= k; j++) {
                if (j > i) {
                    dp[i][j] = 0l;
                } else if (j == i) {
                    dp[i][j] = (long)fastPow(5, i, mod);
                } else {
                    dp[i][j] = (long)modMul((int)dp[i - 1][j - 1], 5, mod);
                }
                sum = modAdd(sum, (int)dp[i][j], mod);
            }
        }
        return sum;
    }

    public int fastPow(int x, int y, int mod) {
        if (y == 0) return 1;
        if (y == 1) return (x % mod);

        int temp = fastPow(x, y / 2, mod);
        int ans = modMul(temp, temp, mod);

        return (y % 2 == 1) ? modMul(ans, x, mod) : ans;
    }
    private int modMul(int n, int x, int mod) {
        return (int)(((((long)n * x) % mod) + mod) % mod);
    }
    private int modAdd(int n, int x, int mod) {
        return (int)(((((long)n + x) % mod) + mod) % mod);
    }
}
