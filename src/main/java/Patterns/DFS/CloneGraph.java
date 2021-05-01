package main.java.Patterns.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    Node newSource;

    public Node cloneGraph(Node node) {
        Map<Node, Boolean> isVisited = new HashMap<>();
        Node newSource = null;
        dfs(node, isVisited, newSource);
        return this.newSource;
    }

    private void dfs(Node source, Map<Node, Boolean> isVisited, Node newSource) {
        newSource = new Node(source.val);
        isVisited.putIfAbsent(newSource, true);
        if (isVisited.size() == 1) {
            this.newSource = newSource;
        }
        for (Node neighbour : source.neighbors) {
            if (!isVisited.containsKey(neighbour)) {
                newSource.neighbors.add(neighbour);
                neighbour.neighbors.add(newSource);
                dfs(neighbour, isVisited, newSource);
            }
        }
    }
}


class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}