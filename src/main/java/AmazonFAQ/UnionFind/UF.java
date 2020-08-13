package main.java.AmazonFAQ.UnionFind;

public class UF {

    private int[] parent;
    private int[] rank;
    private int count;

    public UF(int noOfVertices) {
        count = noOfVertices;
        parent = new int[noOfVertices];
        rank = new int[noOfVertices];
        assignParent(noOfVertices);
    }

    private void assignParent(int noOfVertices) {
        for (int i = 0; i < noOfVertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU == rootV) {
            return;
        }
        if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
        count--;
    }

    public int find(int vertex) {
        while (vertex != parent[vertex]) {
            parent[vertex] = parent[parent[vertex]];
            vertex = parent[vertex];
        }
        return vertex;
    }

    public boolean connected(int u, int v) {
        return find(u) == find(v);
    }

    public int count() {
        return count;
    }
}
