/*
    https://practice.geeksforgeeks.org/problems/minimum-insertions-to-make-two-arrays-equal/1/#
*/

// Aproach 1- time,space->O(n*m)
class Solution {
    private static int[][] dp;
    static int minInsAndDel(int[] A, int[] B, int n, int m) {
        dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(A, B, n - 1, m - 1);
    }

    private static int helper(int[] A, int[] B, int i, int j) {
        if (j == -1) {
            return i + 1;
        }
        if (i == -1) {
            return j + 1;
        }
        if (dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        if (A[i] == B[j]) ans = helper(A, B, i - 1, j - 1);

        int ans1 = helper(A, B, i - 1, j) + 1;
        int ans2 = helper(A, B, i, j - 1) + 1;
        return dp[i][j] = Math.min(ans1, Math.min(ans2, ans));
    }
};


//Aproach 2- time->O(nlogn), space->O(n)
class Solution {
    static int minInsAndDel(int[] A, int[] B, int n, int m) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < m; i++) {
            set.add(B[i]);
        }
        for (int i = 0; i < n; i++) {
            if (set.contains(A[i])) {
                temp.add(A[i]);
            }
        }

        if (temp.size() == 0) {
            return (n + m);
        } else if (temp.size() == 1) {
            return (n + m - 2);
        } else {
            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans.add(temp.get(0));
            for (int i = 1; i < temp.size(); i++) {
                if (temp.get(i) > ans.get(ans.size() - 1)) {
                    ans.add(temp.get(i));
                } else {
                    ans.set(binSearch(ans, 0, ans.size() - 1, temp.get(i)), temp.get(i));
                }
            }
            return (n + m - ans.size() * 2);
        }
    }

    private static int binSearch(ArrayList<Integer> arr, int start, int end, int search) {
        int mid = (start + end) / 2;
        if (start == end) {
            return start;
        }
        if (arr.get(mid) < search) {
            return binSearch(arr, mid + 1, end, search);
        } else if (arr.get(mid) > search) {
            return binSearch(arr, start, mid, search);
        } else {
            return mid;
        }
    }
};
