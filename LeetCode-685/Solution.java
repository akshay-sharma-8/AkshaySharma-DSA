class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        int[][] incoming = new int[parent.length][];
        int[] first = null;
        int[] second = null;
        for (int[] edge : edges) {
            int child = edge[1];
            if (incoming[child] != null) {
                first = incoming[child];
                second = edge;
                break;
            }
            incoming[child] = edge;
        }

        for (int[] edge : edges) {
            if (edge == second) {
                continue;
            }
            int from = find(parent, edge[0]);
            int to = find(parent, edge[1]);
            if (from == to) {
                return first == null ? edge : first;
            }
            parent[to] = from;
        }
        return second;
    }

    private int find(int[] parent, int node) {
        while (node != parent[node]) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }
}
