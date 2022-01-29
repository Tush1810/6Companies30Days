/*
    https://leetcode.com/problems/find-array-given-subset-sums/
*/

class Solution {

    public int[] recoverArray(int n, int[] sums) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i : sums) arr.add(i);
        Collections.sort(arr);

        int ans[] = new int[n];
        int count = 0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        ArrayList<Integer> notContainsX;
        ArrayList<Integer> containsX;
        int dif;

        while (arr.size() > 1 && count < n) {
            memo.clear();
            for (int i : arr) {
                memo.put(i, memo.getOrDefault(i, 0) + 1);
            }
            notContainsX = new ArrayList<>();
            containsX = new ArrayList<>();

            dif = arr.get(arr.size() - 1) - arr.get(arr.size() - 2);
            containsX.add(arr.get(arr.size() - 1));
            notContainsX.add(arr.get(arr.size() - 2));
            memo.put(arr.get(arr.size() - 1), memo.get(arr.get(arr.size() - 1)) - 1);
            memo.put(arr.get(arr.size() - 1) - dif, memo.get(arr.get(arr.size() - 1) - dif) - 1);
            for (int i = arr.size() - 3; i >= 0; i--) {
                if (memo.containsKey(arr.get(i)) && memo.get(arr.get(i)) > 0) {
                    if (memo.containsKey(arr.get(i) - dif) && memo.get(arr.get(i) - dif) > 0) {
                        containsX.add(arr.get(i));
                        notContainsX.add(arr.get(i) - dif);
                        memo.put(arr.get(i), memo.get(arr.get(i)) - 1);
                        memo.put(arr.get(i) - dif, memo.get(arr.get(i) - dif) - 1);
                    } else {
                        notContainsX.add(arr.get(i));
                        memo.put(arr.get(i), memo.get(arr.get(i)) - 1);
                    }
                }
            }
            boolean found = false;
            for (int i : notContainsX) {
                if (i == 0) {
                    found = true;
                    break;
                }
            }
            if (found) {
                arr = notContainsX;
                ans[count++] = dif;
            } else {
                arr = containsX;
                ans[count++] = 0 - dif;
            }
            for (int i = 0, j = arr.size() - 1; i < j; i++, j--) {
                arr.set(i, arr.get(i) + arr.get(j));
                arr.set(j, arr.get(i) - arr.get(j));
                arr.set(i, arr.get(i) - arr.get(j));
            }
        }

        return ans;
    }
}
