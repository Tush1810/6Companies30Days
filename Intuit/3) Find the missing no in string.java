/*
    https://practice.geeksforgeeks.org/problems/find-the-missing-no-in-string/1/#
*/

class GfG {
    public int missingNumber(String s) {
        int n = s.length(), temp = -1, ans = -1, num = -1;
        StringBuilder sb = new StringBuilder();
        for (int length = 1; length <= 6; length++) {
            sb.append(s.charAt(length - 1));
            num = Integer.parseInt(sb.toString());
            num++;
            int l = String.valueOf(num).length();
            boolean found = false;
            int i = length;
            for (; i + l <= n;) {
                l = String.valueOf(num).length();
                temp = Integer.parseInt(s.substring(i, i + l));
                i += l;
                if (found) {
                    if (temp == num) {
                        num++;
                    } else break;
                } else {
                    if (temp == num) {
                        num++;
                    } else {
                        if (l == String.valueOf((int)(num + 1)).length()) {
                            if (temp == num + 1) {
                                num = temp + 1;
                                found = true;
                                ans = temp - 1;
                            } else {
                                break;
                            }
                        } else {
                            temp = (temp * 10);
                            if (temp == num + 1) {
                                num = temp + 1;
                                found = true;
                                ans = temp - 1;
                            } else {
                                break;
                            }
                            i++;
                            l = String.valueOf(num).length();
                        }
                    }
                }
            }
            if (i == n) {
                return ans;
            }
        }
        return -1;
    }
}
