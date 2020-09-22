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
    private ArrayList[] graph;
    private boolean[] isVisited;
    private boolean[] onStack;
    boolean isCyclic;
    Queue<Integer> postOrder;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        hasCycle(numCourses, prerequisites);
        if (isCyclic) {
            return new int[]{};
        }
        postOrder = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i]) {
                dfs_postOrder(graph, i);
            }
        }

        for (int course : postOrder) {
            if (numCourses <= 0) {
                return result;
            }
            result[numCourses - 1] = course;
            numCourses--;
        }
        return result;
    }


    private void dfs_postOrder(ArrayList[] graph, int course) {
        isVisited[course] = true;
        List<Integer> neighbours = graph[course];
        for (int neighbour : neighbours) {
            if (!isVisited[neighbour]) {
                dfs_postOrder(graph, neighbour);
            }
        }
        postOrder.add(course);
    }

    private void hasCycle(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        isVisited = new boolean[numCourses];
        onStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i] && !isCyclic) {
                dfs_cyclicity(graph, i);
            }
        }
        Arrays.fill(isVisited, false);
    }

    private void dfs_cyclicity(ArrayList[] graph, int course) {
        isVisited[course] = true;
        onStack[course] = true;
        List<Integer> neighbours = graph[course];
        for (int neighbour : neighbours) {
            if (isCyclic) {
                return;
            } else if (!isVisited[neighbour]) {
                dfs_cyclicity(graph, neighbour);
            } else if (onStack[neighbour]) {
                isCyclic = true;
            }
        }
        onStack[course] = false;
    }

    public static void main(String[] args) {
        CourseSchedule2 top = new CourseSchedule2();
        int[][] preq = {{0,1}, {1,0}};
        System.out.println(Arrays.toString(top.findOrder(2, preq)));
    }
}
