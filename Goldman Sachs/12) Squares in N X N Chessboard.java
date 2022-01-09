/*
    https://practice.geeksforgeeks.org/problems/squares-in-nn-chessboard1801/1
*/

class Solution {
    static Long squaresInChessBoard(Long n) {
        long ans = n;
        ans *= (n + 1);
        ans *= (2 * n + 1);
        ans /= 6;
        return ans;
    }
};
