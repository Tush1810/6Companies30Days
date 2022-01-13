/*
    https://practice.geeksforgeeks.org/problems/column-name-from-a-given-column-number4244/1/#
*/

class Solution {
    String colName (long n) {
        if (n <= 26) {
            return String.valueOf(((char)((int)'A' + n - 1)));
        }
        StringBuilder sb = new StringBuilder();
        long temp;
        for (; n != 0;) {
            n--;
            temp = n % 26;
            sb.append((char)((int)'A' + temp));
            n /= 26;
        }

        return sb.reverse().toString();
    }
}
