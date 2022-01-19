/*
    https://practice.geeksforgeeks.org/problems/find-smallest-range-containing-elements-from-k-lists/1/#
*/

class Solution {
    private static class Num {
        public int kIndex, data, nIndex;
        Num(int data, int kIndex) {
            this.nIndex = 0;
            this.kIndex = kIndex;
            this.data = data;
        }
    }
    static int[] findSmallestRange(int[][] arr, int n, int k) {
        int[] ans = new int[2];
        PriorityQueue<Num> pq = new PriorityQueue<>((o1, o2)-> {
            return o1.data - o2.data;
        });

        int max = -1, range;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, arr[i][0]);
            pq.add(new Num(arr[i][0], i));
        }
        range = max - pq.peek().data;
        ans[0] = pq.peek().data;
        ans[1] = max;
        Num temp;
        while (true) {
            temp = pq.poll();
            if (temp.nIndex == n - 1) break;
            temp.nIndex = temp.nIndex + 1;
            temp.data = arr[temp.kIndex][temp.nIndex];
            max = Math.max(max, temp.data);
            pq.add(temp);
            if ((range > max - pq.peek().data)) {
                ans[1] = max;
                ans[0] = pq.peek().data;
                range = ans[1] - ans[0];
            }
        }
        return ans;
    }
}
