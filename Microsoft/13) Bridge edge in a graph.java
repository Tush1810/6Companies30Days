/*
    https://practice.geeksforgeeks.org/problems/bridge-edge-in-graph/1#
*/

class Solution {
    private static boolean isVisited[];
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        adj.get(c).remove(new Integer(d));
        adj.get(d).remove(new Integer(c));
        isVisited = new boolean[V];
        if (isConnected(c, d, adj)) return 0;
        return 1;
    }

    static boolean isConnected(int i, int v, ArrayList<ArrayList<Integer>> adj) {
        dfs(i, adj);
        if (!isVisited[v])
            return false;
        return true;
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> adj) {
        isVisited[i] = true;
        for (Integer next : adj.get(i)) {
            if (isVisited[next]) continue;
            dfs(next, adj);
        }
    }
}
