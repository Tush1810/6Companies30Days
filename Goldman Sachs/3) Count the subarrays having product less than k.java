/*
    https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1/#
*/

class Solution {

    public int countSubArrayProductLessThanK(long arr[], long n, long k) {
        int left = -1, right = -1, ans = 0;
        long temp = arr[0];
        while (right < n) {
            if (right > left) {
                if (temp < k) {
                    ans += right - left;
                    if (right + 1 < n) {
                        right++;
                        temp *= arr[right];
                    } else break;
                } else {
                    left++;
                    temp /= arr[left];
                }
            } else {
                if (right + 1 >= n) break;
                right++;
                temp = arr[right];
            }
        }
        return ans;
    }

}
