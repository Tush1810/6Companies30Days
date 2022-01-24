/*
    https://leetcode.com/problems/number-of-boomerangs/submissions/
*/

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int ans = 0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            memo.clear();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int dis1 = Math.abs(points[j][0] - points[i][0]), dis2 = Math.abs(points[j][1] - points[i][1]);
                int key = dis1 * dis1 + dis2 * dis2;
                memo.put(key, memo.getOrDefault(key, 0) + 1);
            }
            for (Integer temp : memo.values()) {
                if (temp > 1) {
                    ans += temp * (temp - 1);
                }
            }
        }
        return ans;
    }
}
