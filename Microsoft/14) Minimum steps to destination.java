/*
    https://practice.geeksforgeeks.org/problems/minimum-number-of-steps-to-reach-a-given-number5234/1/#
*/

class Solution {
    static int minSteps(int D) {
        int sum = 0;
        for (int i = 1;; i++) {
            if (sum + i == D) return i;
            if (sum + i > D) {
                if ((sum + i - D) % 2 != 0) {
                    if ((sum + 2 * i + 1 - D) % 2 != 0) {
                        return i + 2;
                    } else return i + 1;
                }
                return i;
            }
            sum += i;
        }
    }
}
