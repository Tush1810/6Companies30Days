/*
    https://practice.geeksforgeeks.org/problems/next-higher-palindromic-number-using-the-same-set-of-digits5859/1/#
*/

class Solution {
    public String nextPalin(String s) {
        int n = s.length();
        int[] freq = new int[10];
        StringBuilder sb = new StringBuilder();
        for (int i = (n / 2) - 1; i > 0; i--) {
            if (getInt(s.charAt(i)) > getInt(s.charAt(i - 1))) {
                sb.append(s.substring(0, i - 1));
                for (int q = i - 1; q < n / 2; q++) freq[getInt(s.charAt(q))]++;
                for (int q = getInt(s.charAt(i - 1)) + 1; q < 10; q++) {
                    if (freq[q] != 0) {
                        sb.append(q);
                        freq[q]--;
                        break;
                    }
                }

                for (int q = 0; q < 10;) {
                    if (freq[q] == 0) {
                        q++;
                        continue;
                    }
                    sb.append(q);
                    freq[q]--;
                }
                if (n % 2 == 1) {
                    sb.append(s.charAt((n / 2)));
                    for (int q = sb.length() - 2; q > -1; q--) {
                        sb.append(sb.charAt(q));
                    }
                } else {
                    for (int q = sb.length() - 1; q > -1; q--) {
                        sb.append(sb.charAt(q));
                    }
                }
                return sb.toString();
            }
        }
        return "-1";
    }

    private int getInt(char ch) {
        return (int)(ch - '0');
    }
}
