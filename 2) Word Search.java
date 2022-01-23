/*
    https://practice.geeksforgeeks.org/problems/word-search/1/#
*/

class Solution {
    public boolean isWordExist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(i, j, 0, board, word, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(int i, int j, int pos, char[][] board, String word, boolean[][] visited) {
        if ((i < 0 || (i > (board.length - 1)) || j < 0 || (j > (board[0].length - 1)))) {
            return false;
        }
        if (word.charAt(pos) == board[i][j] && !visited[i][j]) {
            visited[i][j] = true;
        } else return false;
        if (pos == word.length() - 1) return true;

        boolean ans = helper(i - 1, j, pos + 1, board, word, visited) || helper(i + 1, j, pos + 1, board, word, visited) || helper(i, j - 1, pos + 1, board, word, visited) || helper(i, j + 1, pos + 1, board, word, visited);
        visited[i][j] = false;
        return ans;
    }
}
