/*
    https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1/#
*/

class Solution {
    private class Num {
        Node node;
        int height;
        Num(Node node, int height) {
            this.node = node;
            this.height = height;
        }
    }
    //Function to connect nodes at same level.
    public void connect(Node root) {
        Deque<Num> dq = new LinkedList<>();
        dq.addLast(new Num(root, 1));
        Num prev = null;
        while (dq.size() != 0) {
            if (prev != null && dq.peekFirst().height == prev.height) {
                prev.node.nextRight = dq.peekFirst().node;
            }
            prev = dq.pollFirst();
            if (prev.node.left != null)
                dq.addLast(new Num(prev.node.left, prev.height + 1));
            if (prev.node.right != null)
                dq.addLast(new Num(prev.node.right, prev.height + 1));
        }
    }
}
