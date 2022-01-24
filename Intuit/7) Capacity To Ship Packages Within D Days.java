/*
    https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/submissions/
*/

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = weights[0], end = weights[0];
        for (int i = 1; i < weights.length; i++) {
            start = Math.max(weights[i], start);
            end += weights[i];
        }
        int ans = end;
        while (start <= end) {
            int dayCount = 0, sum = 0, maxVal = 0, mid = (start + end) / 2;

            for (int i = 0; i < weights.length; i++) {
                if (weights[i] + sum > mid) {
                    dayCount++;
                    sum = weights[i];
                } else {
                    sum += weights[i];
                }
                maxVal = Math.max(sum, maxVal);
            }
            if (dayCount < days) {
                ans = Math.min(maxVal, ans);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
