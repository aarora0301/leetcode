package main.java.AmazonFAQ.Graphs.TopologicalSort;

import java.util.*;

/*****
 * There are a total of n courses you have to take labelled from 0 to n - 1.
 *
 * Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi
 * before the course ai.
 *
 * Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you
 * should take to finish all courses.
 *
 * If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses
 * 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 */
public class CourseSchedule2 {

    boolean isCyclic;

    private Map<Integer, List<Integer>> depMap;
    private Set<Integer> isVisitedSet;
    private Set<Integer> onStackSet;
    Queue<Integer> postOrder;
    List<Integer> cycleList;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int index = numCourses - 1;
        int[] result = new int[numCourses];
        hasCycle(numCourses, prerequisites);
        if (isCyclic) {
            return new int[]{};
        }

        for (int num : postOrder) {
            result[index--] = num;
        }
        return result;
    }


    private void hasCycle(int numCourses, int[][] prerequisites) {
        depMap = new HashMap<>();
        isVisitedSet = new HashSet<>();
        onStackSet = new HashSet<>();
        cycleList = new ArrayList<>();
        postOrder = new LinkedList<>();

        for (int[] pre : prerequisites) {
            depMap.putIfAbsent(pre[1], new ArrayList<>());
            depMap.get(pre[1]).add(pre[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!isVisitedSet.contains(i) && !isCyclic) {
                dfs_cyclicity(i);
            }
        }

    }

    private void dfs_cyclicity(int course) {
        isVisitedSet.add(course);
        onStackSet.add(course);
        List<Integer> neighbours = depMap.get(course);
        if (neighbours == null) {

        } else {

            for (int neighbour : neighbours) {
                if (isCyclic) {
                    return;
                } else if (!isVisitedSet.contains(neighbour)) {
                    dfs_cyclicity(neighbour);
                } else if (onStackSet.contains(neighbour)) {
                    isCyclic = true;
                    cycleList.add(course);
                    cycleList.add(neighbour);
                }
            }
        }

        onStackSet.remove(course);
        postOrder.add(course);

    }

    public static void main(String[] args) {
        CourseSchedule2 top = new CourseSchedule2();
        int[][] preq = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(top.findOrder(4, preq)));
    }
}
