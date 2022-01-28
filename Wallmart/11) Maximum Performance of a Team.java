/*
    https://leetcode.com/problems/maximum-performance-of-a-team/submissions/
*/

class Solution {
    private class Num {
        int index;
        long speed, e;
        Num(int index, int speed, int e) {
            this.index = index;
            this.speed = (long)speed;
            this.e = (long)e;
        }
    }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Num[] arr = new Num[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Num(i, speed[i], efficiency[i]);
        }
        Arrays.sort(arr, (o1, o2)-> {
            if (o1.e > o2.e) {
                return -1;
            } else if (o1.e < o2.e) {
                return 1;
            } else return 0;
        });
        return (int)helper(arr, k, n);
    }

    private long helper(Num[] arr, int k, int n) {
        long sum = 0;
        PriorityQueue<Long> pq = new PriorityQueue<Long>((o1, o2)-> {
            if (o1 > o2) return 1;
            if (o1 < o2) return -1;
            return 0;
        });
        long ans = Integer.MIN_VALUE;
        for (Num num : arr) {
            pq.add(num.speed);
            sum += num.speed;
            if (pq.size() > k) {
                sum = sum - pq.poll();
            }
            ans = Math.max(ans, sum * num.e);
        }
        return ans % (1_000_000_007l);
    }
}
