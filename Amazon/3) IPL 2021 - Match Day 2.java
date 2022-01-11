/*
    https://practice.geeksforgeeks.org/problems/deee0e8cf9910e7219f663c18d6d640ea0b87f87/1/
*/

class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            while (dq.size() > 0 && dq.peekLast() < arr[i]) {
                dq.pollLast();
            }
            dq.addLast(arr[i]);
        }

        for (int i = k - 1; i < n; i++) {
            while (dq.size() > 0 && dq.peekLast() < arr[i]) {
                dq.pollLast();
            }
            dq.addLast(arr[i]);

            ans.add(dq.peekFirst());

            if (dq.peekFirst() == arr[i - k + 1]) {
                dq.pollFirst();
            }
        }

        return ans;
    }
}
