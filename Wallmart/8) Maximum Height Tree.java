/*
    https://practice.geeksforgeeks.org/problems/maximum-height-tree4803/1/?page=2&company[]=Walmart&query=page2company[]Walmart#
*/

class Solution {
    static int height(int N) {
        long n = 2 * N;
        double temp = Math.sqrt(1 + 4 * n);
        double ans = temp - 1;
        ans /= 2;
        return (int)Math.floor(ans);
    }
}
