package main.java.AmazonFAQ.Graphs.UnionFind;


/***
 * There are n computers numbered from 0 to n-1 connected by ethernet cables connections forming a network where
 * connections[i] = [a, b] represents a connection between computers a and b. Any computer can reach any other computer directly
 * or indirectly through the network.
 *
 * Given an initial computer network connections. You can extract certain cables between two directly connected computers, and
 * place them between any pair of disconnected computers to make them directly connected. Return the minimum number of times you
 * need to do this in order to make all the computers connected. If it's not possible, return -1.
 *
 *
 */
public class NetworkConnected {

    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1) {
            return -1;
        }
        final UF uf = new UF(n);
        for (int[] singleConnection : connections) {
            uf.union(singleConnection[0], singleConnection[1]);
        }
        return uf.count()-1;
    }

    public static void main(String[] args) {
        NetworkConnected networkConnected= new NetworkConnected();
        System.out.println(networkConnected.makeConnected(4, new int[][]{{0,1},{1,2},{2,0}}));
    }
}