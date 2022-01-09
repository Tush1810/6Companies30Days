/*
    https://leetcode.com/problems/minimum-size-subarray-sum/
*/

class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int left = -1, right = -1;
        int n = arr.length;
        int sum = 0, ans = Integer.MAX_VALUE;
        while (right < n) {
            if (left < right) {
                if (sum >= target) {
                    ans = Math.min(ans, right - left);
                    left++;
                    sum -= arr[left];
                } else {
                    if (right + 1 < n) {
                        right++;
                        sum += arr[right];
                    } else {
                        break;
                    }
                }
            } else {
                if (right + 1 < n) {
                    right++;
                    sum += arr[right];
                } else {
                    break;
                }
            }
        }
        if (ans == Integer.MAX_VALUE) return 0;
        return ans;
    }
}
