package main.java._30DayLeetcoding;

import java.util.Currency;

/***
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumberOfIslands {

    int count = 0;

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int currRow = 0, currCol = currRow;
        // int count = 0;
        backTrack(row, col, currRow, currCol, grid);
        return count;
    }

    private void backTrack(int row, int col, int currRow, int currCol, char[][] grid) {
        if (currRow > row - 1) {
            return;
        }
        for (int i = currRow; i < row; i++) {
            if (i > currRow) {
                continue;
            }
            backTrack(row, col, i + 1, currCol, grid);
            for (int j = currCol; j < col; j++) {
                if (rowColCheck(row, col, currRow, currCol, grid)) {
                    count = count + 1;
                    return;
                }
            }
            currCol = 0;
        }
    }

    private boolean rowColCheck(int row, int col, int currRow, int currCol, char[][] arr) {
//        return currRow - 1 >= 0 && currRow + 1 < row && currCol - 1 >= 0 && currCol + 1 < col
//                && arr[currRow][currCol] == '0' && arr[currRow - 1][currCol] == '0'
//                && arr[currRow + 1][currCol] == '0' && arr[currRow][currCol - 1] == '0'
//                && arr[currRow][currCol + 1] == '0';
//
        boolean flag = false;


        if (currRow == 0 && currCol == 0) {
            return (currRow + 1 < row && arr[currRow + 1][currCol] == '0') || (currCol + 1 < col && arr[currRow][currCol + 1] == '0') ;

        } else if (currRow == 0 && currCol == col - 1) {
             return (arr[currRow][currCol - 1] == '0') || (currRow + 1 < row && arr[currRow + 1][currCol] == '0') ;
            }
        else if (currRow == row - 1 && currCol == 0) {
            return (arr[currRow-1][currCol]=='0')|| (currCol+1< col && arr[currRow][currCol+1]=='0');
        }else if(currRow==row-1 && currCol==col-1){
            return (arr[currRow][currCol-1]=='0') ||
        }


    }

    public static void main(String[] args) {
        NumberOfIslands test = new NumberOfIslands();
        System.out.println(test.numIslands(new char[][]{{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}}));
    }
}
