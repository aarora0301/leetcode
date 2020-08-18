package main.java.AmazonFAQ.UnionFind;


/****
 * On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.
 *
 * Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
 *
 * What is the largest possible number of moves we can make?
 *
 *
 *
 * Example 1:
 *
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * Output: 5
 * Example 2:
 *
 * Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * Output: 3
 */
public class MostStonesRemoved {

    public int removeStones(int[][] stones) {
        int n = stones.length;
        final UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; i < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    uf.union(i, j);
                }
            }
        }
        return n - uf.count();
    }

}
