/*
    https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1#
*/

class Tree {
    //Function to serialize a tree and return a list containing nodes of tree.
    public void serialize(Node root, ArrayList<Integer> A) {
        if (root == null) {
            A.add(-1);
            return;
        }
        A.add(root.data);
        serialize(root.left, A);
        serialize(root.right, A);
    }

    //Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A) {
        Node root = new Node(A.get(0));
        helper(A, 1, root);
        return root;
    }

    public int helper(ArrayList<Integer> A, int start, Node root) {
        if (start >= A.size()) return -1;
        Node temp = root;
        if (A.get(start) != -1) {
            temp = new Node(A.get(start));
            root.left = temp;
            start++;
            start = helper(A, start, root.left);
            if (A.get(start) != -1) {
                temp = new Node(A.get(start));
                root.right = temp;
                start++;
                return helper(A, start, root.right);
            } else {
                start++;
                return start;
            }
        } else {
            start++;
            if (A.get(start) != -1) {
                temp = new Node(A.get(start));
                root.right = temp;
                start++;
                return helper(A, start, root.right);
            } else {
                start++;
                return start;
            }
        }
    }
};
