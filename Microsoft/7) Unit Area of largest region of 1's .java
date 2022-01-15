/*
    https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s-1587115620/1/
*/

class Solution {
    private int n, m;
    private long ans;
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] arr) {
        n = arr.length;
        m = arr[0].length;
        ans = 0;
        boolean[][] temp = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !temp[i][j]) {
                    helper(arr, i, j, temp);
                }
            }
        }
        return (int)ans;
    }

    private long helper(int[][] arr, int i, int j, boolean[][] temp) {
        if (i == -1 || i == n || j == -1 | j == m) return 0;
        if (arr[i][j] == 0) return 0;
        if (temp[i][j]) return 0;

        temp[i][j] = true;

        long anss = 0;

        anss = anss + helper(arr, i + 1, j, temp);
        anss = anss + helper(arr, i - 1, j, temp);
        anss = anss + helper(arr, i, j + 1, temp);
        anss = anss + helper(arr, i, j - 1, temp);
        anss = anss + helper(arr, i + 1, j + 1, temp);
        anss = anss + helper(arr, i + 1, j - 1, temp);
        anss = anss + helper(arr, i - 1, j + 1, temp);
        anss = anss + helper(arr, i - 1, j - 1, temp);

        anss++;
        ans = Math.max(anss, ans);
        return anss;
    }
}
