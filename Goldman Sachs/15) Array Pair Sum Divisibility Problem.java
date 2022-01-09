/*
    https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1#
*/

class Solution {
    public boolean canPair(int[] arr, int k) {
        int n = arr.length;
        if (n % 2 != 0) return false;
        int count0 = 0;
        for (int i = 0; i < n; i++) {
            arr[i] %= k;
            if (arr[i] == 0) count0++;
        }
        if (count0 % 2 != 0) return false;

        HashMap<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            memo.put(arr[i], memo.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) continue;
            if ((!memo.containsKey(k - arr[i])) || memo.get(k - arr[i]) == 0) return false;
            memo.put(k - arr[i], memo.get(k - arr[i]) - 1);
        }
        return true;
    }
}
