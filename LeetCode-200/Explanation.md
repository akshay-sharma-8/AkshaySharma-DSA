# 200. Number of Islands

**Approach: Depth-First Search (DFS)**

## Idea

Each connected group of land cells (`'1'`) forms one island. When land is found, increase the island count and use DFS to visit every connected land cell. Mark visited land as water (`'0'`) so it is not counted again.

## Steps

1. Check whether the grid is empty. If it is, return `0`.
2. Traverse every cell in the grid.
3. If a cell contains `'1'`:
   - Increase the island count.
   - Start DFS from that cell.
4. In DFS, stop if the position is outside the grid or the cell is not unvisited land.
5. Mark the current land cell as `'0'`.
6. Recursively visit the four neighbours: up, down, left, and right.
7. After the traversal, return the island count.

## Complexity

Let `m` be the number of rows and `n` be the number of columns.

- **Time:** O(m × n), because each cell is visited at most once.
- **Space:** O(m × n) worst case for the recursive DFS call stack, when the grid is mostly land.

**Key concept:** Graph traversal using DFS on a 2D grid.

**Note:** The algorithm modifies the input grid by marking visited land cells as water.
