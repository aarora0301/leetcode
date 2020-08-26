package main.java.AmazonFAQ.BFS;


import java.util.*;

/********
 * A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company has is the one with headID.
 *
 * Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee,
 * manager[headID] = -1. Also it's guaranteed that the subordination relationships have a tree structure.
 *
 * The head of the company wants to inform all the employees of the company of an urgent piece of news. He will inform his direct
 * subordinates and they will inform their subordinates and so on until all employees know about the urgent news.
 *
 * The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e After informTime[i] minutes,
 * all his direct subordinates can start spreading the news).
 *
 * Return the number of minutes needed to inform all the employees about the urgent news.
 *
 * Example 1:
 *
 * Input: n = 1, headID = 0, manager = [-1], informTime = [0]
 * Output: 0
 * Explanation: The head of the company is the only employee in the company.
 *
 *
 * Example 2:
 *
 *
 * Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
 * Output: 1
 * Explanation: The head of the company with id = 2 is the direct manager of all the employees in the company and needs 1 minute
 * to inform them all.
 * The tree structure of the employees in the company is shown.
 */
public class InformEmployees {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                map.get(manager[i]).add(i);
            }
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, headID));
        int max = 0;
        while (!queue.isEmpty()) {
            Pair top = queue.poll();
            for (int child : map.get(top.id)) {
                queue.add(new Pair(informTime[top.id] + top.time, child));
                max = Math.max(max, informTime[top.id] + top.time);
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }

    class Pair {
        int time, id;

        Pair(int time, int id) {
            this.time = time;
            this.id = id;
        }
    }
}
