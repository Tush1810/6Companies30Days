/*
    https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1/
*/

class Solution {
    public void toSumTree(Node root) {
        dfs(root);
    }
    private int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int temp = left + right + root.data;
        root.data = left + right;
        return temp;
    }
}
