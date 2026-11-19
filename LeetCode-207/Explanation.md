# 207. Course Schedule

## Approach: Depth-First Search (DFS)

- Build a directed graph from each prerequisite to the course that depends on it.
- Use three states: `0` = not visited, `1` = currently visiting, and `2` = completed.
- If DFS reaches a course in state `1`, a cycle exists.
- A cycle means not all courses can be completed, so return `false`.
- If no cycle is found, return `true`.

## Complexity
- **Time:** O(V + E), where V is the number of courses and E is the number of prerequisite pairs.
- **Space:** O(V + E) for the graph and DFS state/recursion.