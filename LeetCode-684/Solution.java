class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int from = find(parent, edge[0]);
            int to = find(parent, edge[1]);
            if (from == to) {
                return edge;
            }
            parent[to] = from;
        }
        return new int[0];
    }

    private int find(int[] parent, int node) {
        while (node != parent[node]) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }
}
