/*
    https://practice.geeksforgeeks.org/problems/number-following-a-pattern3126/1#
*/

class Solution {
    static String printMinNumberForPattern(String S) {
        int n = S.length();
        char[] arr = S.toCharArray();

        HashMap<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'D') {
                int count = 1;
                int j;
                for (j = i + 1; j < n && arr[j] != 'I'; j++) count++;
                memo.put(i, count);
                i = j;
            }
        }
        String ans = "";
        int start = 0;
        int doneTill = 0;
        if (arr[0] == 'I' && 1 < n && arr[1] == 'D') {
            int temp = memo.get(1) + 2;
            ans = "1";
            ans += temp;
            doneTill = 1;
            start = 1;
        } else if (memo.containsKey(0)) {
            ans = func(memo, ans, doneTill, start);
            doneTill = memo.get(start) + 1;
            start = doneTill - 1;
            ans = doneTill + ans;
        } else {
            ans = "12";
            doneTill = 2;
            start = 1;
        }

        for (int i = start; i < n; i++) {
            if (arr[i] == 'I' && ((i + 1 < n && arr[i + 1] != 'D') || i + 1 == n)) {
                doneTill++;
                ans += doneTill;
            } else if (arr[i] == 'D') {
                ans = func(memo, ans, doneTill, i);
                doneTill = doneTill + memo.get(i);
                i += (memo.get(i) - 1);
                doneTill++;
            } else {
                int temp = doneTill + memo.get(i + 1) + 1;
                ans += temp;
            }
        }
        return ans;
    }
    static String func(HashMap<Integer, Integer> memo, String ans, int doneTill, int index) {
        for (int i = doneTill + memo.get(index); i > doneTill; i--) {
            ans += i;
        }
        return ans;
    }
}
