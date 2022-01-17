/*
    https://practice.geeksforgeeks.org/problems/express-as-sum-of-power-of-natural-numbers5647/1#
*/

class Solution {
    static ArrayList<Integer> arr;
    private static long dp[][];
    static long numOfWays(int n, int x) {
        if (n == 1) return 1;
        arr = new ArrayList<Integer>();
        arr.add(0);
        int sum = 0;
        for (int i = 1; arr.get(arr.size() - 1) < n; i++) {
            arr.add(fastPow(i, x));
        }
        dp = new long[arr.size()][n + 1];
        for (int i = 0; i < arr.size(); i++) Arrays.fill(dp[i], -1);
        return check(1, n, 0);
    }
    private static long check(int i, int n, int sum) {
        if (sum == n) return 1l;
        if (i >= arr.size()) return 0l;
        if (sum > n) return 0l;
        if (dp[i][sum] != -1) return dp[i][sum];
        return dp[i][sum] = check(i + 1, n, sum) + check(i + 1, n, sum + arr.get(i));
    }

    static int fastPow(int n, int x) {
        if (n == 1) return 1;
        if (x == 1) return n;
        if (x == 2) return n * n;

        if (x % 2 == 1) return fastPow(fastPow(n, x / 2), 2) * n;
        else return fastPow(fastPow(n, x / 2), 2);
    }
}
