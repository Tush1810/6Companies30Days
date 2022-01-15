/*
    https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1/
*/

class Solution {
    private static int right, left, top, down;
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        right = c;
        left = -1;
        top = -1;
        down = r;

        traverse(matrix, ans, i, j, true, false, false);
        return ans;
    }

    public static void traverse(int[][] matrix, ArrayList<Integer> ans, int i, int j, boolean goingRight, boolean goingLeft, boolean goingUp) {
        if (i == top || i == down || j == right || j == left) return;

        if (goingRight) {
            ans.add(matrix[i][j]);
            if (right > j + 1) {
                traverse(matrix, ans, i, j + 1, true, false, false);
            } else {
                top++;
                traverse(matrix, ans, i + 1, j, false, false, false);
            }
        } else if (goingUp) {
            ans.add(matrix[i][j]);
            if (top < i - 1) {
                traverse(matrix, ans, i - 1, j, false, false, true);
            } else {
                left++;
                traverse(matrix, ans, i, j + 1, true, false, false);
            }
        } else if (goingLeft) {
            ans.add(matrix[i][j]);
            if (left < j - 1) {
                traverse(matrix, ans, i, j - 1, false, true, false);
            } else {
                down--;
                traverse(matrix, ans, i - 1, j, false, false, true);
            }
        } else {
            ans.add(matrix[i][j]);
            if (down > i + 1) {
                traverse(matrix, ans, i + 1, j, false, false, false);
            } else {
                right--;
                traverse(matrix, ans, i, j - 1, false, true, false);
            }
        }
    }
}
