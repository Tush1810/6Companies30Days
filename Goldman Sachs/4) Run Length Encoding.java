/*
    https://practice.geeksforgeeks.org/problems/run-length-encoding/1/#
*/

class GfG {
    String encode(String str) {
        int n = str.length(), count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            if (str.charAt(i - 1) != str.charAt(i)) {
                sb.append(str.charAt(i - 1));
                sb.append(count);
                count = 1;
            } else count++;
        }
        sb.append(str.charAt(n - 1));
        sb.append(count);
        return sb.toString();
    }
}
