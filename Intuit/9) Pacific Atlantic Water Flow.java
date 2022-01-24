/*
    https://leetcode.com/problems/pacific-atlantic-water-flow/
*/

class Solution {
    List<List<Integer>> ans;
    boolean[][] visited;
    int n, m;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ans = new ArrayList<>();
        n = heights.length;
        m = heights[0].length;

        visited = new boolean[n][m];
        ArrayList<Integer> temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (helper(i, j, heights, true) && helper(i, j, heights, false)) {
                    temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

    private boolean helper(int i, int j, int[][] arr, boolean checkPacific) {
        if (checkPacific && (i - 1 == -1 || j - 1 == -1)) return true;
        if (!checkPacific && (i + 1 == n || j + 1 == m)) return true;

        visited[i][j] = true;
        if (i + 1 < n && arr[i + 1][j] <= arr[i][j] && !visited[i + 1][j]) {
            if (helper(i + 1, j, arr, checkPacific)) {
                visited[i][j] = false;
                return true;
            }
        }
        if (i - 1 >= 0 && arr[i - 1][j] <= arr[i][j] && !visited[i - 1][j]) {
            if (helper(i - 1, j, arr, checkPacific)) {
                visited[i][j] = false;
                return true;
            }
        }
        if (j - 1 >= 0 && arr[i][j - 1] <= arr[i][j] && !visited[i][j - 1]) {
            if (helper(i, j - 1, arr, checkPacific)) {
                visited[i][j] = false;
                return true;
            }
        }
        if (j + 1 < m && arr[i][j + 1] <= arr[i][j] && !visited[i][j + 1]) {
            if (helper(i, j + 1, arr, checkPacific)) {
                visited[i][j] = false;
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
