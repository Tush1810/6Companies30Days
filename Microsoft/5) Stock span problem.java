/*
    https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1#
*/

class Solution {
    private static class Pair {
        public int data, index;
        Pair(int data, int index) {
            this.data = data;
            this.index = index;
        }
    }
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        int[] ans = new int[n];
        Deque<Pair> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (dq.size() == 0) {
                ans[i] = i + 1;
            } else if (dq.peekLast().data > price[i]) {
                ans[i] = 1;
            } else {
                while (dq.size() != 0 && dq.peekLast().data <= price[i]) {
                    dq.pollLast();
                }
                if (dq.size() == 0) {
                    ans[i] = i + 1;
                } else {
                    ans[i] = i - dq.peekLast().index;
                }
            }
            dq.addLast(new Pair(price[i], i));
        }
        return ans;
    }
}
