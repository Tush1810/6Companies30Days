/*
    https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1/#
*/

class Solution {
    public class Graph {
        private class Node {
            private int data;
            public int indegree;
            public int outdegree;
            private Deque<Edge> incomingEdges;
            private Deque<Edge> outgoingEdges;

            Node(int data) {
                this.indegree = 0;
                this.outdegree = 0;
                this.data = data;
                incomingEdges = new LinkedList<>();
                outgoingEdges = new LinkedList<>();
            }

            void addIncomingEdge(Edge edge) {
                indegree++;
                incomingEdges.add(edge);
            }
            void addOutgoingEdge(Edge edge) {
                outdegree++;
                outgoingEdges.add(edge);
            }

            boolean canBeDone() {
                if (indegree == 0) return true;
                return false;
            }
            void addNodesToBeCheckedAndDoneEdges(Deque<Node> free) {
                for (Edge e : outgoingEdges) {
                    e.to.indegree--;
                    if (e.to.canBeDone()) {
                        free.addLast(e.to);
                    }
                }
            }
        }
        private class Edge {
            public Node from;
            public Node to;
            public int weight;
            Edge(int weight, Node from, Node to) {
                this.weight = weight;
                this.from = from;
                this.to = to;
            }
            Edge(Node from, Node to) {
                this.weight = 1;
                this.from = from;
                this.to = to;
            }
        }

        HashMap<Integer, Node> nodes;
        HashSet<Node> freeNodes;

        Graph() {
            nodes = new HashMap<>();
            freeNodes = new HashSet<>();
        }

        public void addNode(int data) {
            Node node = new Node(data);
            nodes.put(data, node);
            freeNodes.add(node);
        }

        public void addEdge(int from, int to) {
            Node fromNode = nodes.get(from);
            Node toNode = nodes.get(to);
            if (freeNodes.contains(toNode)) freeNodes.remove(toNode);
            if (fromNode == null || toNode == null) {
                throw new NullPointerException();
            }
            Edge edge = new Edge(fromNode, toNode);

            fromNode.addOutgoingEdge(edge);
            toNode.addIncomingEdge(edge);
        }

        public boolean topoLogicalSort() {
            int count = 0;
            Deque<Node> free = new LinkedList<>();
            for (Node n : freeNodes) {
                free.add(n);
            }
            for (; free.size() != 0;) {
                count++;
                free.pollFirst().addNodesToBeCheckedAndDoneEdges(free);
            }
            if (count == nodes.size()) return true;
            else return false;
        }
    }

    public boolean isPossible(int N, int[][] prerequisites) {
        Graph graph = new Graph();
        int n = prerequisites.length;
        for (int i = 0; i < N; i++) {
            graph.addNode(i);
        }
        for (int i = 0; i < n; i++) {
            graph.addEdge(prerequisites[i][1], prerequisites[i][0]);
        }
        return graph.topoLogicalSort();
    }
}
