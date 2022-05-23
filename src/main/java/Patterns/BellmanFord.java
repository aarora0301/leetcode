package Patterns;

import java.util.Arrays;

public class BellmanFord {

    public int networkDelayTime(int[][] times, int n, int k) {
        if (times == null || times.length == 0) {
            return -1;
        }

        int[] path = new int[n+1];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[k] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < times.length; j++) {
                int u = times[j][0];
                int v = times[j][1];
                int w = times[j][2];

                if (path[u] != Integer.MAX_VALUE && path[u] + w < path[v]) {
                    path[v] = path[u] + w;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (path[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, path[i]);
        }

        return ans;
    }
}
