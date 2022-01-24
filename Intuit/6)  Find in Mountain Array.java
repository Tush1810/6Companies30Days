/*
    https://leetcode.com/problems/find-in-mountain-array/
*/

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int start = 0, end = n - 1, ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid == 0) {
                start = mid + 1;
                continue;
            } else if (mid == n - 1) {
                end = mid - 1;
                continue;
            }
            int atMid = mountainArr.get(mid);
            int atMidMinusOne = mountainArr.get(mid - 1);
            int atMidPlusOne = mountainArr.get(mid + 1);
            if (atMid > atMidPlusOne && atMid > atMidMinusOne) {
                ans = mid;
                if (target == atMid) return mid;
                break;
            } else if (atMid < atMidPlusOne && atMid > atMidMinusOne) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }


        start = 0;
        end = ans - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int atMid = mountainArr.get(mid);
            if (atMid == target) {
                return mid;
            } else if (atMid > target) {
                end = mid - 1;
            } else start = mid + 1;
        }

        start = ans + 1;
        end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int atMid = mountainArr.get(mid);
            if (atMid == target) {
                return mid;
            } else if (atMid < target) {
                end = mid - 1;
            } else start = mid + 1;
        }
        return -1;
    }
}
