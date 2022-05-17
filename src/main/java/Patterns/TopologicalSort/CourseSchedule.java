package Patterns.TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {


    Boolean cycleExist = Boolean.FALSE;

    public boolean canFinish(final int numCourses, final int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return false;
        }

        Map<Integer, List<Integer>> map = evaluateCourses(prerequisites);
        final Set<Integer> isVisited = new HashSet<>();
        final Set<Integer> onStack = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (cycleExist == false && !isVisited.contains(i)) {
                dfs(i, map, isVisited, onStack);
            }
        }

        return cycleExist == false;

    }

    private void dfs(final int course, Map<Integer, List<Integer>> map, Set<Integer> isVisited, Set<Integer> onStack) {
        isVisited.add(course);
        onStack.add(course);
        List<Integer> neighbours = map.get(course);
        if (neighbours != null) {
            for (int neighbour : neighbours) {
                if (cycleExist) {
                    return;
                } else if (!isVisited.contains(neighbour)) {
                    dfs(neighbour, map, isVisited, onStack);
                } else if (onStack.contains(neighbour)) {
                    cycleExist = Boolean.TRUE;
                }
            }
        }
        onStack.remove(course);
    }

    private Map<Integer, List<Integer>> evaluateCourses(final int[][] prerequisites) {
        Map<Integer, List<Integer>> dependency = new HashMap<>();

        for (int[] courses : prerequisites) {
            dependency.putIfAbsent(courses[1], new ArrayList<>());
            dependency.get(courses[1]).add(courses[0]);
        }
        return dependency;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] courses = new int[][]{{1, 0}, {0, 1}};
        System.out.println(courseSchedule.canFinish(2, courses));
    }

}
