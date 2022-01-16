/*
    https://practice.geeksforgeeks.org/problems/bridge-edge-in-graph/1#
*/

class Solution {
    private static boolean isVisited[];
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        adj.get(c).remove(new Integer(d));
        adj.get(d).remove(new Integer(c));
        isVisited = new boolean[V];
        dfs(c, d, adj);
        if (isVisited[d]) return 0;
        return 1;
    }
    private static void dfs(int i, int d, ArrayList<ArrayList<Integer>> adj) {
        isVisited[i] = true;
        if (d == i) return;
        for (Integer next : adj.get(i)) {
            if (isVisited[next]) continue;
            dfs(next, d, adj);
        }
    }
}
