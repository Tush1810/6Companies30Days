/*
    https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/submissions/
*/

class Solution {
    public boolean winnerOfGame(String colors) {
        int countA = 0, countB = 0;
        int n = colors.length();
        for (int i = 0; i < n - 2; i++) {
            if (colors.charAt(i) == 'A' && colors.charAt(i + 1) == 'A' && colors.charAt(i + 2) == 'A') {
                countA++;
                int j;
                for (j = i + 3; j < n; j++) {
                    if (colors.charAt(j) == 'A') {
                        countA++;
                    } else {
                        i = j - 1;
                        break;
                    }
                }
                if (j == n) break;
            } else if (colors.charAt(i) == 'B' && colors.charAt(i + 1) == 'B' && colors.charAt(i + 2) == 'B') {
                countB++;
                int j;
                for (j = i + 3; j < n; j++) {
                    if (colors.charAt(j) == 'B') {
                        countB++;
                    } else {
                        i = j - 1;
                        break;
                    }
                }
                if (j == n) break;
            }
        }

        if (countA <= countB) {
            return false;
        } else return true;
    }
}
