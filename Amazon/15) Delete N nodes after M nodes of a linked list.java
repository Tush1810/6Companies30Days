/*
    https://practice.geeksforgeeks.org/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/1/#
*/

class Solution {
    static void linkdelete(Node head, int M, int N) {
        Node temp = head, prev = null;
        int count = 0;
        for (count = 0; temp != null; count++) {
            if (count == M) {
                Node temp2 = temp;
                for (int i = 0; i < N && temp2 != null; i++) {
                    temp2 = temp2.next;
                }
                if (prev == null) {
                    head = temp2;
                    temp = head.next;
                } else {
                    prev.next = temp2;
                    temp = prev.next;
                }
                count = -1;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
    }
}
