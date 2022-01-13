/*
    https://practice.geeksforgeeks.org/problems/nuts-and-bolts-problem0431/1#
*/

class Solution {
    void matchPairs(char nuts[], char bolts[], int n) {
        ArrayList<Character> list = new ArrayList<>();
        list.add('!');
        list.add('#');
        list.add('$');
        list.add('%');
        list.add('&');
        list.add('*');
        list.add('@');
        list.add('^');
        list.add('~');

        helper(list, nuts);
        helper(list, bolts);
    }

    void helper(ArrayList<Character> list, char[] arr) {
        char ch;
        int i = 0, n = arr.length;
        for (int q = 0; q < 9; q++) {
            ch = list.get(q);
            for (int j = i; j < n; j++) {
                if (arr[j] == ch) {
                    swap(arr, i, j);
                    i++;
                }
            }
        }
    }

    void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
