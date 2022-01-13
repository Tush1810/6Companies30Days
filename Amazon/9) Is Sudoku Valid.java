/*
    https://practice.geeksforgeeks.org/problems/is-sudoku-valid4820/1/#
*/

class Solution {
    static int isValid(int arr[][]) {
        int[] temp = new int[10];
        for (int i = 0; i < 9; i++) {
            temp = new int[10];
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] != 0 && temp[arr[i][j]] == 1) {
                    return 0;
                } else {
                    temp[arr[i][j]]++;
                }
            }
        }
        for (int j = 0; j < 9; j++) {
            temp = new int[10];
            for (int i = 0; i < 9; i++) {
                if (arr[i][j] != 0 && temp[arr[i][j]] == 1) {
                    return 0;
                } else {
                    temp[arr[i][j]]++;
                }
            }
        }
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                temp = new int[10];
                for (int i = row * 3; i < row * 3 + 3; i++) {
                    for (int j = column * 3; j < column * 3 + 3; j++) {
                        if (arr[i][j] != 0 && temp[arr[i][j]] == 1) {
                            return 0;
                        } else {
                            temp[arr[i][j]]++;
                        }
                    }
                }
            }
        }
        return 1;
    }
}
