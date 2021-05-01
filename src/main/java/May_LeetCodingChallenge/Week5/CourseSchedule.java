package main.java.May_LeetCodingChallenge.Week5;

import java.util.ArrayList;
import java.util.List;

/****
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed
 * as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 *
 * Solution:
 *  Check if cycle exists in a direct graph, if cycle exists means course can not be finished
 */
public class CourseSchedule {

    List<Integer>[] graph;
    boolean[] visited;
    boolean[] onRecursionStack;
    boolean isCyclic;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        isCyclic = false;
        graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        /**
         *  create a directed graph
         */
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        visited = new boolean[numCourses];
        onRecursionStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!isCyclic) {
                    dfs(i);
                }
            }
        }
        /***
         *  if cycle exists course cannot be converted
         *   hence if cyclic = true return false
         *   if cyclic = false, return true
         */
        return !isCyclic;
    }

    private void dfs(int vertex) {
        visited[vertex] = true;
        onRecursionStack[vertex] = true;

        for (int neighbour : graph[vertex]) {
            if (isCyclic) {
                return;
            } else if (!visited[neighbour]) {
                dfs(neighbour);
            } else if (onRecursionStack[neighbour]) {
                isCyclic = true;
            }
        }
        /**
         *  Remove vertex from stack after recursion completes
         *  or when it has no neighbours
         */
        onRecursionStack[vertex] = false;
    }

    public static void main(String[] args) {
        CourseSchedule test = new CourseSchedule();
        System.out.println(test.canFinish(4, new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 2}}));
    }
}
