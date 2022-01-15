/*
    https://practice.geeksforgeeks.org/problems/count-number-of-subtrees-having-given-sum/1/
*/

class Tree {
    private int count;
    //Function to count number of subtrees having sum equal to given sum.
    int countSubtreesWithSumX(Node root, int X) {
        count = 0;
        dfs(root, X);
        return count;
    }

    private int dfs(Node root, int x) {
        if (root == null) return 0;

        int ans = dfs(root.left, x);
        ans += dfs(root.right, x);

        ans += root.data;
        if (ans == x) {
            count++;
        }
        return ans;
    }
}
