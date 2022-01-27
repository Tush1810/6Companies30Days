/*
    https://practice.geeksforgeeks.org/problems/power-of-numbers-1587115620/1/?company[]=Walmart&company[]=Walmart&page=1&query=company[]Walmartpage1company[]Walmart
*/

class Solution {
    long power(int N, int R) {
        return fastPow((long)N, (long)R, 1_000_000_007l);
    }
    private long fastPow(long n, long k, long mod) {
        if (n == 0) return 0;
        if (n == 1 || k == 0) return 1;
        if (k == 2) return ((((n * n) % mod) + mod) % mod);

        if (k % 2 == 0) {
            return fastPow(fastPow(n, k / 2, mod), 2l, mod);
        } else {
            return ((((fastPow(fastPow(n, k / 2, mod), 2l, mod) * n) % mod) + mod) % mod);
        }
    }
}
