import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int required = prerequisite[1];
            graph.get(required).add(course);
        }

        int[] state = new int[numCourses];
        // 0 = not visited, 1 = visiting, 2 = completed

        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(course, graph, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int course, List<List<Integer>> graph, int[] state) {
        if (state[course] == 1) {
            return true;
        }

        if (state[course] == 2) {
            return false;
        }

        state[course] = 1;

        for (int nextCourse : graph.get(course)) {
            if (hasCycle(nextCourse, graph, state)) {
                return true;
            }
        }

        state[course] = 2;
        return false;
    }
}
