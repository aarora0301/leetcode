package Patterns.UF;

public class StonesRemoved {


    public int removeStones(int[][] stones) {
        UF uf = new UF(stones.length);
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (connected(stones[i], stones[j])) {
                    uf.union(i, j);
                }
            }
        }
        return stones.length - uf.count;
    }

    private boolean connected(int[] u, int[] v) {
        return u[0] == v[0] || u[1] == v[1];
    }

    public static void main(String[] args) {
        StonesRemoved sr = new StonesRemoved();
        System.out.println(sr.removeStones(new int[][]{{0, 0}}));

    }

    private class UF {

        int count;
        private int[] parent;
        private int[] rank;

        public UF(int vertices) {
            count = vertices;
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

        private int find(int vertex) {
            while (vertex != parent[vertex]) {
                parent[vertex] = parent[parent[vertex]];
                vertex = parent[vertex];
            }
            return vertex;
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
