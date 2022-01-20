package main.java.AmazonFAQ.Graphs.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test {

    public int getMinTime(char[][] grid, int row, int col, Queue<Point> q){
        int minTime=Integer.MIN_VALUE;
        if(grid==null || grid.length==0){
            return minTime;
        }

        for(int i=0; i< row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j]=='*'){
                    q.offer(new Point(i, j));
                }
            }
        }
        int[][] directions= {{-1,0}, {1,0}, {0,-1}, {0,1}};

        minTime=0;
        while (!q.isEmpty()){
            Point top= q.poll();
            for(int[] d: directions){
                int neighborRow= top.x+ d[0];
                int neighbourCol= top.y+ d[1];
                if(neighborRow <0 || neighborRow >= row || neighbourCol<0 || neighbourCol>= col ){
                    continue;
                }
                if (grid[neighborRow][neighbourCol]=='.'){
                    grid[neighborRow][neighbourCol]='*';
                    q.offer(new Point(neighborRow, neighbourCol));
                }
            }
            minTime++;
        }
        return minTime;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] t = new char[n][m];
        for(int i=0; i<n ;i++){
            for(int j=0; j<m; j++){
                t[i][j]= in.next().charAt(0);
            }
        }
        Queue<Point> q = new LinkedList<Point>();
        test source= new test();
        int min= source.getMinTime(t, n, m, q);
        System.out.print(min);
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    }
}

class Point {
    int x, y;

    Point(int x, int y) {

    }
}