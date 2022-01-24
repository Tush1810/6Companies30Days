/*
    https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/submissions/
*/

class Solution {
    private int count = Integer.MAX_VALUE, n, m;
    public int minSwaps(int[][] grid) {
        int[] ans = new int[grid.length];
        n = grid.length;
        m = grid[0].length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int j;
            ans[i] = -1;
            for (j = m - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    ans[i] = j;
                    sum += j;
                    break;
                }
            }
        }
        if (sum > ((n) * (n - 1)) / 2) {
            return -1;
        }
        helper(ans, 0, 0);
        if (count == Integer.MAX_VALUE) return -1;
        return count;
    }
    private void helper(int[] ans, int i, int c) {
        if (i == ans.length) {
            count = Math.min(count, c);
            return;
        }
        if (ans[i] > i) {
            for (int j = i + 1; j < n; j++) {
                if (ans[j] <= i) {
                    int k = j - 1;
                    int countTemp = 0;
                    while (k >= i) {
                        countTemp++;
                        swap(ans, k, k + 1);
                        k--;
                    }
                    helper(ans, i + 1, c + countTemp);
                    break;
                }
            }
        } else {
            helper(ans, i + 1, c);
        }
    }
    private void swap(int[] ans, int i, int j) {
        ans[i] = ans[i] + ans[j];
        ans[j] = ans[i] - ans[j];
        ans[i] = ans[i] - ans[j];
    }
}
