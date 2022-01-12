/*
    https://practice.geeksforgeeks.org/problems/count-ways-to-nth-stairorder-does-not-matter1322/1/
*/

class Solution {
    //Function to count number of ways to reach the nth stair
    //when order does not matter.
    Long countWays(int m) {
        if (m == 1) return 1l;
        if (m == 0) return 0l;
        if (m == 2 || m == 3) return 2l;

        return countWays(m - 2) + 1;
    }
}
