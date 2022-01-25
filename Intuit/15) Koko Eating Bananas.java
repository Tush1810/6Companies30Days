/*
    https://leetcode.com/problems/koko-eating-bananas/submissions/
*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int ans = Integer.MAX_VALUE, temp = 0;
        int start = 1, end = piles[piles.length - 1];
        while (start < end) {
            int mid = (start + end) / 2;
            temp = 0;
            for (int i = 0; i < piles.length; i++) {
                if (piles[i] % mid == 0) {
                    temp += (piles[i] / mid);
                } else {
                    temp += ((piles[i] / mid) + 1);
                }
            }
            if (temp > h) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }
}
