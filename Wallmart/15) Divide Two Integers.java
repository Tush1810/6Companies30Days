/*
    https://leetcode.com/problems/divide-two-integers/
*/

class Solution {
    public int divide(int dividend, int divisor) {
        long ans = 0;
        boolean isNeg = ((dividend < 0) ^ (divisor < 0));
        long a = dividend, b = divisor;
        if (dividend < 0) {
            a = -a;
        }
        if (divisor < 0) {
            b = -b;
        }
        for (int i = 31; i >= 0; i--) {
            if ((b << i) <= a) {
                ans += (1l << i);
                a -= b << i;
            }
        }
        if (isNeg) ans = -ans;
        if (ans <= ((-1l << 31))) {
            return (int)((-1l << 31));
        }
        if (ans >= ((1l << 31) - 1)) {
            return (int)((1l << 31) - 1);
        }
        return (int)ans;
    }
}
