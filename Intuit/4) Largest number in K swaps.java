/*
    https://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1#
*/

class Solution {
    static ArrayList<HashSet<Integer>> arr;
    static String max;
    static StringBuilder sb;

    public static String findMaximumNum(String str, int k) {
        max = str;
        sb = new StringBuilder();
        arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) arr.add(new HashSet<Integer>());

        int n = str.length();
        for (int i = 0; i < n; i++) {
            arr.get(str.charAt(i) - '0').add(i);
        }
        sb.append(str);
        helper(0, k);
        return max;
    }

    private static void helper(int pos, int k) {
        if (pos == sb.length()) {
            if (sb.toString().compareTo(max) > 0) {
                max = sb.toString();
            }
            return;
        }
        if (k == 0) {
            helper(pos + 1, k);
            return;
        }
        for (int i = 9; (i > (sb.charAt(pos) - '0')); i--) {
            if (arr.get(i).size() != 0) {
                char temp2;
                boolean atleastOneSwap = false;
                ArrayList<Integer> temp3 = new ArrayList<>();
                for (int temp : arr.get(i)) temp3.add(temp);
                for (int temp : temp3) {
                    if (temp < pos) continue;
                    atleastOneSwap = true;
                    arr.get(i).remove(temp);
                    arr.get((sb.charAt(pos) - '0')).remove(pos);
                    arr.get((sb.charAt(pos) - '0')).add(temp);
                    temp2 = sb.charAt(pos);
                    sb.setCharAt(pos, sb.charAt(temp));
                    sb.setCharAt(temp, temp2);
                    helper(pos + 1, k - 1);
                    temp2 = sb.charAt(pos);
                    sb.setCharAt(pos, sb.charAt(temp));
                    sb.setCharAt(temp, temp2);
                    arr.get(i).add(temp);
                    arr.get((sb.charAt(pos) - '0')).remove(temp);
                    arr.get((sb.charAt(pos) - '0')).add(pos);
                }
                if (atleastOneSwap)
                    return;
            }
        }
        helper(pos + 1, k);
    }
}
