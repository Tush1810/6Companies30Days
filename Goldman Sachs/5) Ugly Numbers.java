/*
    https://practice.geeksforgeeks.org/problems/ugly-numbers2254/1/#
*/

class Solution {
    long getNthUglyNo(int n) {
        long arr[] = new long[n];
        arr[0] = 1;
        int index[] = new int[3];
        long nextUgly[] = new long[3];
        nextUgly[0] = 2;
        nextUgly[1] = 3;
        nextUgly[2] = 5;
        long num;
        for (int i = 1; i < n; i++) {
            num = nextUgly[0];
            if (num > nextUgly[1]) num = nextUgly[1];
            if (num > nextUgly[2]) num = nextUgly[2];
            arr[i] = num;
            if (num == nextUgly[0]) {
                index[0]++;
                nextUgly[0] = arr[index[0]] * 2;
            }
            if (num == nextUgly[1]) {
                index[1]++;
                nextUgly[1] = arr[index[1]] * 3;
            }
            if (num == nextUgly[2]) {
                index[2]++;
                nextUgly[2] = arr[index[2]] * 5;
            }
        }
        return arr[n - 1];
    }
}
