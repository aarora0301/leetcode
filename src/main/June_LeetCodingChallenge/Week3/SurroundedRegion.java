package main.June_LeetCodingChallenge.Week3;

/****
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped
 * to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 * Visualisation: https://www.youtube.com/watch?v=PIwYN5h4LwU
 */
public class SurroundedRegion {

    public void solve(char[][] board) {
        if(board.length == 0) return;
        int row = board.length;
        int col = board[0].length;
        /**
         * Traverse first row and last column
         * so boundary cells and its neighbour should not be converted to 'X'
         * so mark them with '*', indicates that cell is visited
         */
        for(int i = 0; i < col; i++){
            if(board[0][i] == 'O')
                dfs(board, 0, i);
            if(board[row- 1][i] == 'O')
                dfs(board, row - 1, i);
        }
        /***
         * Traverse first row and last row
         *  so boundary cells and its neighbour should not be converted to 'X'
         *  so mark them with '*', indicates that cell is visited
         */
        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O')
                dfs(board, i, 0);
            if(board[i][col - 1] == 'O')
                dfs(board, i, col - 1);
        }

        /***
         *  Traverse the entire board again
         *  this time
         *  perform two steps:
         *   1. if cell is marked '*' means it is not surrounded so convert it back to 'O'
         *   2. if cell is marked 'O' means it can be surrounded so convert it into 'X'
         */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int row, int col) {
        /**
         *  board[row][col]!='O' means cell is already visited as dfs block can be entered only when
         *   board[row][col]=='O'
         */
        if (row < 0 || col < 0 || row > board.length - 1 || col > board[0].length - 1 || board[row][col] != 'O') {
            return;
        }
        board[row][col] = '*';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}
