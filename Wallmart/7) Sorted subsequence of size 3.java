/*
    https://practice.geeksforgeeks.org/problems/sorted-subsequence-of-size-3/1/#
*/

class Solution {
    ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr.get(0));
        int[] pos = new int[3];
        pos[0] = 0;
        for (int i = 1; i < n; i++) {
            if (arr.get(i) > ans.get(ans.size() - 1)) {
                ans.add(arr.get(i));
                if (ans.size() == 3) {
                    pos[2] = i;
                    for (int j = pos[1] - 1; j >= 0; j--) {
                        if (arr.get(j) < ans.get(1)) {
                            ans.set(0, arr.get(j));
                            break;
                        }
                    }
                    return ans;
                } else pos[1] = i;
            } else {
                if (arr.get(i) <= ans.get(0)) {
                    pos[0] = i;
                    ans.set(0, arr.get(i));
                } else if (ans.size() >= 2 && arr.get(i) <= ans.get(1)) {
                    pos[1] = i;
                    ans.set(1, arr.get(i));
                }
            }
        }
        ans = new ArrayList<>();
        return ans;
    }
}
