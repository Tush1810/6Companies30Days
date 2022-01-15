/*
    https://practice.geeksforgeeks.org/problems/rotate-by-90-degree0356/1/#
*/

class GFG {
    static void rotate(int matrix[][]) {
        int n = matrix.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            for (int q = 0; q < n; q++) {
                swap(matrix, i, j, q);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j);
            }
        }
    }
    private static void swap(int[][] matrix, int i, int j, int q) {
        matrix[q][i] = matrix[q][i] + matrix[q][j];
        matrix[q][j] = matrix[q][i] - matrix[q][j];
        matrix[q][i] = matrix[q][i] - matrix[q][j];
    }
    private static void swap(int[][] matrix, int i, int j) {
        matrix[i][j] = matrix[i][j] + matrix[j][i];
        matrix[j][i] = matrix[i][j] - matrix[j][i];
        matrix[i][j] = matrix[i][j] - matrix[j][i];
    }
}
