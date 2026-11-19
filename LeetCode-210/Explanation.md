# 210. Course Schedule II

## Approach: Topological Sorting (Kahn's Algorithm)

- Build a directed graph from each prerequisite to its dependent course.
- Calculate the indegree (number of prerequisites) for each course.
- Add every course with indegree `0` to a queue.
- Remove courses from the queue, append them to the answer, and reduce the indegree of their neighbours.
- Add a neighbouring course to the queue when its indegree becomes `0`.
- If all courses are processed, return the order. Otherwise, a cycle exists, so return an empty array.

## Complexity
- **Time:** O(V + E), where V is the number of courses and E is the number of prerequisite pairs.
- **Space:** O(V + E) for the graph, queue, indegree array, and result.