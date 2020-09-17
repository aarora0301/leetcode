package main.java.AmazonFAQ.BFS;

import java.util.LinkedList;
import java.util.Queue;

/******
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 *
 * A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
 *
 * Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
 * C_1 is at location (0, 0) (ie. has value grid[0][0])
 * C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 * If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
 * Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
 *
 *
 */
public class ShortestPath {

    public static void main(String[] args) {

    }

    public int shortestPathBinaryMatrix(int[][] grid) {
         if (grid== null || grid.length==0){
             return -1;
         }
         int row= grid.length;
        int col = grid[0].length;
        if (grid[0][0] == 1 || grid[row-1][col-1] == 1) {
            return -1;
        }
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[]{0,0});
        int ans=0;
        int [][] dir= new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}, {1,-1}, {-1,1},{-1,-1}, {1,1}};
        while (!queue.isEmpty()){
            int size= queue.size();
            for (int i=0; i<size; i++){
               int [] top= queue.remove();
               if (top[0]==row-1 && top[1]== col-1){
                   return ans+1;
               }

              for (int [] directions: dir){
                  int nextX= top[0]+ directions[0];
                  int nextY= top[1]+ directions[1];

                  if (nextX<0 || nextX>= row || nextY<0 || nextY>= col || grid[nextX][nextY]!=0){
                      continue;
                  }
                  grid[nextX][nextY]=1;
                  queue.add(new int[]{nextX, nextY});
              }
            }
            ans++;
        }
        return -1;
    }
}
