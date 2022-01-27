/*
    https://leetcode.com/problems/path-with-maximum-probability/submissions/
*/

class Solution {
    double ans = 0;
    private class Num {
        int index;
        double val;
        Num(int index, double val) {
            this.index = index;
            this.val = val;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<ArrayList<Num>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Num>());
        }

        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(new Num(edges[i][1], succProb[i]));
            list.get(edges[i][1]).add(new Num(edges[i][0], succProb[i]));
        }
        PriorityQueue<Num> pq = new PriorityQueue<>((o1, o2)-> {
            if (o1.val > o2.val) {
                return -1;
            }
            if (o1.val < o2.val) {
                return 1;
            }
            return 0;
        });
        pq.add(new Num(start, 1));
        boolean[] visited = new boolean[n];

        while (pq.size() != 0) {
            Num s = pq.poll();
            if (visited[s.index]) {
                continue;
            }
            visited[s.index] = true;
            if (s.index == end) {
                ans = s.val;
                break;
            }

            for (Num temp : list.get(s.index)) {
                if (!visited[temp.index]) {
                    pq.add(new Num(temp.index, temp.val * s.val));
                }
            }
        }
        return ans;
    }
}
