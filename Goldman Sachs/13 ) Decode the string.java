/*
    https://practice.geeksforgeeks.org/problems/decode-the-string2444/1#
*/

class Solution {
    static String decodedString(String s) {
        s = "1[" + s + "]";
        return decode(s);
    }

    static String decode(String s) {
        String repeating = "";
        int n = s.length();
        long count;
        int i;
        int count2, q;
        String temp;
        for (i = 0; i < n; i++) {
            if (s.charAt(i) == '[') break;
        }
        if (i == 0) count = 1;
        else {
            temp = s.substring(0, i);
            count = Integer.parseInt(temp);
        }
        i++;

        for (; i < n - 1; i++) {
            int j = i;
            while (s.charAt(j) - '0' >= 0 && s.charAt(j) - '0' <= 9) {
                j++;
            }

            if (j == i) {
                count2 = 1;
            } else {
                temp = s.substring(i, j);
                count2 = Integer.parseInt(temp);
            }
            if (s.charAt(j) == '[') {
                j++;
                q = j;
                int countStart = 1;
                while (true) {
                    if (s.charAt(q) == '[') countStart++;
                    else if (s.charAt(q) == ']') {
                        countStart--;
                        if (countStart == 0) break;
                    }
                    q++;
                }
                temp = decode(s.substring(j - 1, q + 1));
                i = q;
            } else {
                q = j;
                while (!(s.charAt(q) - '0' >= 0 && s.charAt(q) - '0' <= 9) && q < n - 1) q++;
                temp = s.substring(j, q);
                i = q - 1;
            }
            for (q = 0; q < count2; q++) {
                repeating += temp;
            }
        }
        String ans = repeating;
        for (i = 1; i < count; i++) {
            ans += repeating;
        }
        return ans;
    }
}
