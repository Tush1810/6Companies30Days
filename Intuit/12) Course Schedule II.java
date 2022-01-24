/*
    https://leetcode.com/problems/course-schedule-ii/
*/

class Solution {
    int[] ans;
    private class Graph {
        private class Node {
            public int num, indegree;
            public ArrayList<Edge> list;
            public Node(int num) {
                this.num = num;
                this.list = new ArrayList<>();
                this.indegree = 0;
            }
            public void addEdge(Edge e) {
                list.add(e);
                e.to.indegree++;
            }
        }
        private class Edge {
            Node from, to;
            int weight;
            Edge(Node from, Node to) {
                this.from = from;
                this.to = to;
                this.weight = 1;
                this.from.addEdge(this);
            }
        }

        HashMap<Integer, Node> memo;
        Graph() {
            this.memo = new HashMap<>();
        }
        public void addNode(int n) {
            memo.put(n, new Node(n));
        }
        public void addEdge(int from, int to) {
            new Edge(memo.get(from), memo.get(to));
        }

        public boolean topologicalSort() {
            Deque<Node> dq = new LinkedList<>();
            for (Node n : memo.values()) {
                if (n.indegree == 0) {
                    dq.addLast(n);
                }
            }
            int count = 0;

            while (dq.size() != 0) {
                Node n = dq.poll();
                ans[count++] = n.num;
                for (Edge e : n.list) {
                    e.to.indegree--;
                    if (e.to.indegree == 0) {
                        dq.addLast(e.to);
                    }
                }
            }
            for (Node n : memo.values()) {
                if (n.indegree != 0) {
                    return false;
                }
            }
            return true;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ans = new int[numCourses];
        Graph g = new Graph();
        for (int i = 0; i < numCourses; i++) {
            g.addNode(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            g.addEdge(prerequisites[i][1], prerequisites[i][0]);
        }

        if (g.topologicalSort()) {
            return ans;
        } else return new int[0];
    }
}
