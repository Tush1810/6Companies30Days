/*
    https://leetcode.com/problems/as-far-from-land-as-possible/submissions/
*/

class Solution {
    private class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        boolean found1 = false, found0 = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    found1 = true;
                }
                if (grid[i][j] == 0) found0 = true;
            }
        }
        if (!found1 || !found0) {
            return -1;
        }
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = Integer.MIN_VALUE;
                } else {
                    grid[i][j] = 0;
                    q.add(new Pair(i, j));
                }
            }
        }

        int[][] directions = new int[][] {{ -1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int ans = 0;

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            for (int[] d : directions) {
                int i = d[0] + temp.x;
                int j = d[1] + temp.y;
                if (i >= 0 && j >= 0 && i < n && j < n && grid[i][j] < 0) {
                    grid[i][j] = grid[temp.x][temp.y] + 1;
                    ans = Math.max(ans, grid[i][j]);
                    q.add(new Pair(i, j));
                }
            }
        }

        return ans;
    }
}
