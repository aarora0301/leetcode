package Patterns.UF;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {

        UF uf = new UF(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

    public static void main(String[] args) {
        //  UF f = new UF(3);
        int[][] arr = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        System.out.println(numberOfProvinces.findCircleNum(arr));

    }


    private static class UF {

        private int count;
        private final int[] parent;
        private final int[] rank;

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
    }
}
