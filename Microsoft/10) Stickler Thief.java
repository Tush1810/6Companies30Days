/*
    https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1/
*/

class Solution {
    private int[] dp;
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n) {
        if (n == 1) return arr[0];
        if (n == 2) return Math.max(arr[0], arr[1]);
        dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(arr, 0);
    }

    private int helper(int[] arr, int i) {
        if (i >= arr.length) return 0;
        if (dp[i] != -1) return dp[i];

        int ans1, ans2;
        ans1 = arr[i] + helper(arr, i + 2);
        ans2 = helper(arr, i + 1);

        return dp[i] = Math.max(ans1, ans2);
    }
}
