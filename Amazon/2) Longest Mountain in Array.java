/*
    https://leetcode.com/problems/longest-mountain-in-array/
*/

class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int count = 0;
        int descCount = 0;
        int longest = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                count++;
            } else if (arr[i] > arr[i + 1]) {
                if (count == 0) continue;
                descCount = 1;
                int j;
                for (j = i + 1; j + 1 < n; j++) {
                    if (arr[j] > arr[j + 1]) descCount++;
                    else break;
                }
                longest = Math.max(longest, count + descCount + 1);
                count = 0;
                descCount = 0;
                i = j - 1;
            } else {
                count = 0;
                descCount = 0;
            }
        }
        return longest;
    }
}
