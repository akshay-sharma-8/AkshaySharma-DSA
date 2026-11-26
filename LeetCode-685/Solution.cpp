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
    vector<int> findRedundantDirectedConnection(vector<vector<int>>& edges) {
        int n = static_cast<int>(edges.size());
        vector<int> parent(n + 1);
        std::iota(parent.begin(), parent.end(), 0);

        vector<int> incoming(n + 1, -1);
        int first = -1;
        int second = -1;
        for (int i = 0; i < n; ++i) {
            int child = edges[i][1];
            if (incoming[child] != -1) {
                first = incoming[child];
                second = i;
                break;
            }
            incoming[child] = i;
        }

        for (int i = 0; i < n; ++i) {
            if (i == second) continue;
            int from = find(parent, edges[i][0]);
            int to = find(parent, edges[i][1]);
            if (from == to) {
                return edges[first == -1 ? i : first];
            }
            parent[to] = from;
        }
        if (second != -1) return edges[second];
        return {};
    }
};
