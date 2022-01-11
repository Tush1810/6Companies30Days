/*
    https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
*/

class Solution {
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (dq.size() > 0 && dq.peekLast() < arr[i]) {
                dq.pollLast();
            }
            dq.add(arr[i]);
        }

        for (int i = k; i < n; i++) {
            ans.add(dq.peekFirst());
            if (dq.peekFirst() == arr[i - k]) {
                dq.pollFirst();
            }
            while (dq.size() > 0 && dq.peekLast() < arr[i]) {
                dq.pollLast();
            }
            dq.add(arr[i]);
        }
        ans.add(dq.peekFirst());
        return ans;
    }
}
