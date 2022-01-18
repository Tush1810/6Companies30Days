/*
    https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/1/
*/

class Solution {
    List<String> ans;
    public List<String> AllParenthesis(int n) {
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        helper(1, 0, n, sb);
        return ans;
    }
    private void helper(int starting, int ending, int n, StringBuilder sb) {
        if (starting > n || ending > n || starting < ending) return;
        if (starting == n && ending == n) {
            ans.add(sb.toString());
            return;
        }

        sb.append('(');
        helper(starting + 1, ending, n, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        helper(starting, ending + 1, n, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
