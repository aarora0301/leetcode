package Patterns.TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _CourseSchdeule2 {


    Boolean cycleExist = Boolean.FALSE;

    public int[] findOrder(final int numCourses, final int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null) {
            return new int[0];
        }

        Map<Integer, List<Integer>> map = evaluateCourses(prerequisites);
        final Set<Integer> isVisited = new HashSet<>();
        final Set<Integer> onStack = new HashSet<>();
        final Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (cycleExist == false && !isVisited.contains(i)) {
                dfs(i, map, isVisited, onStack, queue);
            }
        }

        if (cycleExist){
            return new int[0];
        }

        int index = numCourses - 1;
        int[] result = new int[numCourses];
        while (!queue.isEmpty()){
            result[index--] = queue.poll();
        }
        return result;

    }

    private void dfs(final int course, Map<Integer, List<Integer>> map, Set<Integer> isVisited, Set<Integer> onStack,
                     Queue<Integer> queue) {
        isVisited.add(course);
        onStack.add(course);
        List<Integer> neighbours = map.get(course);
        if (neighbours != null) {
            for (int neighbour : neighbours) {
                if (cycleExist) {
                    return;
                } else if (!isVisited.contains(neighbour)) {
                    dfs(neighbour, map, isVisited, onStack, queue);
                } else if (onStack.contains(neighbour)) {
                    cycleExist = Boolean.TRUE;
                }
            }
        }
        queue.add(course);
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
        _CourseSchdeule2 courseSchdeule2 = new _CourseSchdeule2();
        int[][] courses = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(courseSchdeule2.findOrder(4, courses)));
    }


}
