/*
    https://practice.geeksforgeeks.org/problems/possible-words-from-phone-digits-1587115620/1/
*/

class Solution {
    private static HashMap<Integer, String> memo;
    private static ArrayList<String> ans;
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int arr[], int N) {
        ans = new ArrayList<>();
        memo = new HashMap<>();

        memo.put(2, "abc");
        memo.put(3, "def");
        memo.put(4, "ghi");
        memo.put(5, "jkl");
        memo.put(6, "mno");
        memo.put(7, "pqrs");
        memo.put(8, "tuv");
        memo.put(9, "wxyz");

        StringBuilder sb = new StringBuilder();
        helper(arr, 0, sb);

        return ans;
    }

    static void helper(int[] arr, int i, StringBuilder sb) {
        if (i >= arr.length) {
            ans.add(sb.toString());
            return;
        }

        for (int j = 0; j < memo.get(arr[i]).length(); j++) {
            sb.append(memo.get(arr[i]).charAt(j));
            helper(arr, i + 1, sb);
            sb.deleteCharAt(i);
        }
    }
}
