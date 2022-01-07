/*
    https://practice.geeksforgeeks.org/problems/print-anagrams-together/1/#
*/

class Solution {
    public List<List<String>> Anagrams(String[] arr) {
        int n = arr.length;
        int[][] ans = new int[n][26];
        String s, s2;
        for (int i = 0; i < n; i++) {
            s = arr[i];
            for (int j = 0; j < s.length(); j++) {
                ans[i][s.charAt(j) - 'a']++;
            }
        }

        HashSet<Integer> set = new HashSet<>();
        List<List<String>> ans1 = new ArrayList<>();

        boolean found;
        for (int i = 0; i < n; i++) {
            if (set.contains(i)) continue;
            s = arr[i];
            List<String> temp = new ArrayList<>();
            temp.add(s);
            for (int j = i + 1; j < n; j++) {
                if (set.contains(j)) continue;
                s2 = arr[j];
                found = true;
                for (int q = 0; q < 26; q++) {
                    if (ans[i][q] != ans[j][q]) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    temp.add(s2);
                    set.add(j);
                }
            }
            ans1.add(temp);
            set.add(i);
        }
        return ans1;
    }
}
