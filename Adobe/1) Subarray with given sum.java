/*
    https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1#
*/

class Solution {
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int left = -1, right = -1;
        int sum = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (right < n) {
            if (left < right) {
                if (sum == s) {
                    ans.add(left + 2);
                    ans.add(right + 1);
                    return ans;
                } else if (sum < s) {
                    if (right + 1 < n) {
                        right++;
                        sum += arr[right];
                    } else break;
                } else {
                    left++;
                    sum -= arr[left];
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
        ans.add(-1);
        return ans;
    }
}
