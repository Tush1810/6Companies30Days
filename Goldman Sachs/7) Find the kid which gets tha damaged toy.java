/*
    https://www.geeksforgeeks.org/distributing-m-items-circle-size-n-starting-k-th-position/
*/

public static class Solution {
    public int findIndex(int n, int m, int k) {
        m = m % (n);
        if (m == 0) {
            k--;
            if (k == 0) k = n;
            return k;
        }
        if (m == 1) {
            return k;
        }
        if (m + k - 1 > n) {
            return (m + k - 1) % n;
        } else {
            return m + k - 1;
        }
    }
}

