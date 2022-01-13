/*
    https://practice.geeksforgeeks.org/problems/burning-tree/1/#
*/

class Solution {
    /*class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }*/

    static class Nodee {
        int data, val;
        Nodee left;
        Nodee right;
        Nodee parent;

        Nodee(int data) {
            this.data = data;
            left = null;
            right = null;
            parent = null;
            val = -1;
        }
        Nodee(Node n) {
            this.data = n.data;
            left = null;
            right = null;
            parent = null;
            val = -1;
        }
    }
    private static int MAX;

    public static int minTime(Node root, int target) {
        Nodee root2 = new Nodee(root);
        Nodee target2 = null;
        if (root.left != null)
            target2 = dfs(root.left, root2, true, target);
        if (root.right != null) {
            if (target2 == null)
                target2 = dfs(root.right, root2, false, target);
            else dfs(root.right, root2, false, target);
        }
        if (target2 == null) {
            target2 = root2;
        }
        target2.val = 0;
        MAX = 0;
        findMax(target2.right, 1, 1);
        findMax(target2.left, 1, 1);
        findMax(target2.parent, 0, 1);
        return MAX;
    }

    public static void findMax(Nodee current, int from, int val) {
        // from=0 -->child
        // from=1 -->parent
        if (current == null) return;
        if (val > MAX) MAX = val;
        current.val = val;

        if (from == 0) {
            if (current.left != null && current.left.val == -1) {
                findMax(current.left, 1, val + 1);
            } else if (current.right != null && current.right.val == -1) {
                findMax(current.right, 1, val + 1);
            }
            if (current.parent != null)
                findMax(current.parent, 0, val + 1);
        } else {
            if (current.left != null) {
                findMax(current.left, 1, val + 1);
            }
            if (current.right != null) {
                findMax(current.right, 1, val + 1);
            }
        }
    }

    public static Nodee dfs(Node temp, Nodee parent, boolean isLeft, int target) {
        Nodee n = new Nodee(temp);
        n.parent = parent;

        if (isLeft) {
            parent.left = n;
        } else parent.right = n;

        Nodee toBeReturned = null;
        if (temp.left != null) {
            toBeReturned = dfs(temp.left, n, true, target);
        }
        if (temp.right != null) {
            if (toBeReturned == null) toBeReturned = dfs(temp.right, n, false, target);
            else dfs(temp.right, n, false, target);
        }
        if (n.data == target) {
            return n;
        }
        return toBeReturned;
    }
}
