/*
    https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
*/

class Solution {
    public String FirstNonRepeating(String A) {
        int arr[] = new int[26];
        StringBuilder sb = new StringBuilder();
        char prev = '#', ch = '#';
        int pos = -1;
        for (int i = 0; i < A.length(); i++) {
            if (arr[A.charAt(i) - 'a'] == 0) {
                arr[A.charAt(i) - 'a'] = i + 1;
            } else if (arr[A.charAt(i) - 'a'] > 0) {
                arr[A.charAt(i) - 'a'] = -1;
            }
            if (prev != '#' && arr[prev - 'a'] == 1) {
                sb.append(sb.toString().charAt(sb.length() - 1));
            } else {
                ch = '#';
                pos = Integer.MAX_VALUE;
                for (int q = 0; q < 26; q++) {
                    if (arr[q] > 0 && arr[q] < pos) {
                        pos = arr[q];
                        ch = (char)(q + (int)'a');
                    }
                }
                if (pos == Integer.MAX_VALUE) sb.append('#');
                else {
                    prev = ch;
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
