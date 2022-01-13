/*
    https://leetcode.com/problems/rotting-oranges/
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] arr = new int[n][m];
        int countRotten = 0, countOrange = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) countRotten++;
                if (grid[i][j] == 1) countOrange++;
                if (!(grid[i][j] == 2)) arr[i][j] = -1;
            }
        }

        if (countRotten == 0 && countOrange == 0) return 0;
        if (countOrange > 0 && countRotten == 0) return -1;
        if (countRotten > 0 && countOrange == 0) return 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    dfs(i, j, arr, grid, 0);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, arr[i][j]);
                if (grid[i][j] == 1 && arr[i][j] == -1) return -1;
            }
        }
        return max;

    }

    public void dfs(int i, int j, int[][] arr, int[][] grid, int value) {
        arr[i][j] = value;
        if (i + 1 < grid.length && grid[i + 1][j] == 1 && (arr[i + 1][j] == -1 || arr[i + 1][j] > arr[i][j] + 1)) {
            dfs(i + 1, j, arr, grid, value + 1);
        }
        if (i - 1 > -1 && grid[i - 1][j] == 1 && (arr[i - 1][j] == -1 || arr[i - 1][j] > arr[i][j] + 1)) {
            dfs(i - 1, j, arr, grid, value + 1);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1 && (arr[i][j + 1] == -1 || arr[i][j + 1] > arr[i][j] + 1)) {
            dfs(i, j + 1, arr, grid, value + 1);
        }
        if (j - 1 > -1 && grid[i][j - 1] == 1 && (arr[i][j - 1] == -1 || arr[i][j - 1] > arr[i][j] + 1)) {
            dfs(i, j - 1, arr, grid, value + 1);
        }
    }
}
