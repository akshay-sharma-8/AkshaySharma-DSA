#include <numeric>
#include <vector>

using std::vector;

class Solution {
    int find(vector<int>& parent, int node) {
        while (parent[node] != node) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }

public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        int n = static_cast<int>(edges.size());
        vector<int> parent(n + 1);
        std::iota(parent.begin(), parent.end(), 0);

        for (int i = 0; i < n; ++i) {
            int from = find(parent, edges[i][0]);
            int to = find(parent, edges[i][1]);
            if (from == to) {
                return edges[i];
            }
            parent[to] = from;
        }
        return {};
    }
};
