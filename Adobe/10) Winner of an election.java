/*
    https://practice.geeksforgeeks.org/problems/winner-of-an-election-where-votes-are-represented-as-candidate-names-1587115621/1/#
*/

class Solution {
    private class Candidate {
        String name;
        int votes;
        Candidate(String name) {
            this.name = name;
            this.votes = 0;
        }
    }
    public static String[] winner(String arr[], int n) {
        HashMap<String, Integer> memo = new HashMap<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            memo.put(arr[i], memo.getOrDefault(arr[i], 0) + 1);
            max = Math.max(max, memo.get(arr[i]));
        }
        String ans[] = new String[2];
        ans[1] = String.valueOf(max);

        int i = 0;
        for (String s : memo.keySet()) {
            if (memo.get(s) == max) {
                if (ans[0] == null || ans[0].equals("")) ans[0] = s;
                else {
                    ans[0] = compare(ans[0], s);
                }
            }
        }
        return ans;
    }
    private static String compare(String s1, String s2) {
        int i = 0;
        for (i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return s1;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                return s2;
            }
        }
        if (s1.length() < s2.length()) {
            return s1;
        } else return s2;
    }
}
