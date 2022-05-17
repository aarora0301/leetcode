package Patterns.UF;

import java.util.Arrays;

public class RedundantConnection {


    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length);
        for (int[] edge : edges) {
            uf.union(edge[0] - 1, edge[1] - 1);
        }
        return uf.redundantConnection;
    }

    public static void main(String[] args) {
        RedundantConnection rc = new RedundantConnection();
        System.out.println(
                Arrays.toString(rc.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})));
    }


    private static class UF {

        private int count;
        private final int[] parent;
        private final int[] rank;
        int[] redundantConnection;

        public UF(final int vertices) {
            this.count = vertices;
            parent = new int[vertices];
            rank = new int[vertices];
            assignParent(vertices);
        }

        private void assignParent(int vertices) {
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        private int find(int u) {
            while (u != parent[u]) {
                parent[u] = parent[parent[u]];
                u = parent[u];
            }
            return u;
        }

        public boolean connected(int u, int v) {
            return find(u) == find(v);
        }

        public void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV) {
                redundantConnection = new int[]{u + 1, v + 1};
                return;
            }

            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootV] > rank[rootU]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            count--;
        }

        public int[] connected() {
            return redundantConnection;
        }
    }

}
