package Patterns.UF;

import java.util.ArrayList;
import java.util.HashMap;;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SatisfyEquations {


    public static void main(String[] args) {

    }


    public boolean equationsPossible(String[] equations) {
        UF uf = new UF();
        Map<Character, Set<Character>> disconnectedMap = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        for (String input : equations) {
            if (input.charAt(1) == '=') {
              uf.union(input.charAt(0)-'a', input.charAt(3)-'a');
            }

        }


        for (String input: equations){
            if (input.charAt(1)=='!'){
                if (uf.connected(input.charAt(0)-'a', input.charAt(3)-'a')){
                    return false;
                }
            }
        }
        return true;
    }


    private class UF {

        int[] parent;
        int[] rank;

        public UF() {
            parent = new int[26];
            rank = new int[26];
            assignParent();

        }

        private void assignParent() {
            for (int i = 0; i < 26; i++) {
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
        }

        public boolean connected(int u, int v) {
            return find(u) == find(v);
        }

    }
}
