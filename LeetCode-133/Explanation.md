# 133. Clone Graph

**Approach: Depth-First Search (DFS) with HashMap**

## Idea

We need to create a deep copy of an undirected connected graph. Use a HashMap to store the relationship between each original node and its cloned node.

## Steps

1. If the input node is `null`, return `null`.
2. Check the HashMap:
   - If the original node is already present, return its clone.
3. Otherwise, create a new node with the same value.
4. Store the original node and its clone in the HashMap **before** visiting neighbours. This prevents infinite recursion when the graph contains cycles.
5. Traverse all neighbours of the original node using DFS.
6. Recursively clone each neighbour and add the cloned neighbour to the clone's neighbour list.
7. Return the cloned node.

## Complexity

Let `V` be the number of vertices and `E` be the number of edges.

- **Time:** O(V + E), because each vertex and each adjacency-list edge is processed once.
- **Space:** O(V), for the HashMap and the DFS recursion stack.

**Key concepts:** Graph traversal, DFS, HashMap, deep copy, and cycle handling.

**Note:** LeetCode provides the `Node` class definition. Submit the `Solution` class with the required imports if your local environment needs them (`java.util.*`).
