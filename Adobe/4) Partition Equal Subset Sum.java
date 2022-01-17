/*
    https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
*/

class Solution {
    private static int dp[][];
    private static int target;
    static int equalPartition(int N, int arr[]) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        if (sum % 2 == 1) return 0;
        target = sum / 2;
        dp = new int[N + 1][target + 1];
        if (helper(0, arr, 0)) return 1;
        else return 0;
    }
    private static boolean helper(int i, int[] arr, int sum) {
        if (sum == target) return true;
        if (sum > target) return false;
        if (i >= arr.length) return false;
        if (dp[i][sum] != 0) {
            if (dp[i][sum] == -1) return false;
            else return true;
        }

        if (helper(i + 1, arr, sum + arr[i]) || helper(i + 1, arr, sum)) {
            dp[i][sum] = 1;
            return true;
        } else dp[i][sum] = -1;
        return false;
    }
}
