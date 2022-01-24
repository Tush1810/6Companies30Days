/*
    https://leetcode.com/problems/construct-quad-tree/submissions/
*/

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return helper(0, n - 1, 0, n - 1, grid);
    }
    private Node helper(int up, int down, int left, int right, int[][] grid) {
        Node root = new Node();
        boolean found0 = false, found1 = false;
        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                if (grid[i][j] == 0) found0 = true;
                if (grid[i][j] == 1) found1 = true;
                if (found1 && found0) break;
            }
        }

        if (!found0 || !found1) {
            root.isLeaf = true;
            if (found0) root.val = false;
            else root.val = true;
        } else {
            root.topLeft = helper(up, (up + down) / 2, left, (left + right) / 2, grid);
            root.topRight = helper(up, (up + down) / 2, ((left + right) / 2) + 1, right, grid);
            root.bottomLeft = helper(((up + down) / 2) + 1, down, left, (left + right) / 2, grid);
            root.bottomRight = helper(((up + down) / 2) + 1, down, ((left + right) / 2) + 1, right, grid);
            root.isLeaf = false;
            root.val = true;
        }
        return root;
    }
}
