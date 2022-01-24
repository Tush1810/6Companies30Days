/*
    https://leetcode.com/problems/number-of-provinces/submissions/
*/

class Solution {
    private boolean[] isDone;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        isDone = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!isDone[i]) {
                dfs(i, isConnected);
                ans++;
            }
        }
        return ans;
    }
    private void dfs(int j, int[][] isConnected) {
        isDone[j] = true;
        for (int k = 0; k < isConnected.length; k++) {
            if (isConnected[j][k] == 1 && !isDone[k]) {
                dfs(k, isConnected);
            }
        }
    }
}
