/*
    https://practice.geeksforgeeks.org/problems/number-of-unique-paths5339/1/
*/

class Solution {
    public static int NumberOfPath(int a, int b) {
        return dfs(0, 0, a, b);
    }
    private static int dfs(int i, int j, int n, int m) {
        if (i == n) return 0;
        if (j == m) return 0;

        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        return (dfs(i + 1, j, n, m) + dfs(i, j + 1, n, m));
    }
}
