/*
    https://practice.geeksforgeeks.org/problems/implement-atoi/1/#
*/

class Solution {
    int atoi(String str) {
        long ans = 0, temp = 1, temp2;
        int j = -1;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') j++;
        for (int i = str.length() - 1; i > j; i--) {
            temp2 = getInt(str.charAt(i));
            if (temp2 < 0 || temp2 > 9) return -1;
            ans += (temp * temp2);
            temp *= 10;
        }
        if (j == 0 && str.charAt(0) == '-') {
            ans *= -1;
        }
        return (int)ans;
    }
    long getInt(char ch) {
        return (long)((int)ch - ((int)'0'));
    }
}
