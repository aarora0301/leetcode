package main.java.AmazonFAQ.Graphs.DFS.Cycle;

import java.util.ArrayList;
import java.util.List;

/****
 * In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that
 * is terminal (that is, it has no outgoing directed edges), we stop.
 *
 * Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically,
 * there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than
 * K steps.
 *
 * Which nodes are eventually safe?  Return them as an array in sorted order.
 *
 * The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the
 * following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.
 *
 * Example:
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * Here is a diagram of the above graph.
 *
 * source: https://code.dennyzhang.com/find-eventual-safe-states
 */
public class EventualSafeState {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int[] state = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            dfs(graph, state, i);
        }

        for (int i = 0; i < graph.length; i++) {
            if (state[i] == _state.SAFE.getValue()) {
                result.add(i);
            }
        }
        return result;
    }

    private void dfs(int[][] graph, int[] state, int node) {
        if (state[node] != _state.UNKNOWN.getValue()) {
            /***
             * if a node is already visited and encountered again, that means there is a cycle
             *  mark this node as unsafe
             */
            if (state[node] == _state.VISITING.getValue()) {
                state[node] = _state.UNSAFE.getValue();
            }
            return;

        }

        /**
         *  mark a node as visited whenever it is traversed
         */
        state[node] = _state.VISITING.getValue();


        for (int neighbour : graph[node]) {

            dfs(graph, state, neighbour);
            /***
             * After recursion unfolds
             * if child node is marked unsafe
             *  mark source node as UNSAFE (as it can never be a  terminating node)
             */
            if (state[neighbour] == _state.UNSAFE.getValue()) {
                state[node] = _state.UNSAFE.getValue();
                return;
            }
        }

        /***
         *  if a node has no neighbours/child mark this node as safe
         */
        state[node] = _state.SAFE.getValue();
    }

}


enum _state {
    UNKNOWN(0), VISITING(1), SAFE(2), UNSAFE(3);

    private int value;

    _state(int i) {
        value = i;
    }

    int getValue() {
        return value;
    }
}