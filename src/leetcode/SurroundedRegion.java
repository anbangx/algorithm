package leetcode;
public class SurroundedRegion {

    public void solve(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // base case
        if (board == null || board.length == 0 || board[0].length == 0 || board.length == 1 || board[0].length == 1)
            return;
        // start BFS from the boundary of board
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O')
                BFS(board, i, 0);
            if (board[i][board[0].length - 1] == 'O')
                BFS(board, i, board[0].length - 1);
        }
        for (int i = 1; i < board[0].length - 1; i++) {
            if (board[0][i] == 'O')
                BFS(board, 0, i);
            if (board[board.length - 1][i] == 'O')
                BFS(board, board.length - 1, i);
        }
        // convert 'P' to 'O', 'O' to 'X'
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'P') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1)
                        board[i][j] = 'O';
                    else
                        board[i][j] = 'X';
                }
            }
        }
        return;
    }

    public void BFS(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1)
            return;
        // check if point(x,y) can do BFS
        if (board[x][y] == 'O') {
            board[x][y] = 'P';
            if (x > 1)
                BFS(board, x - 1, y);
            if (x < board.length - 1)
                BFS(board, x + 1, y);
            if (y > 1)
                BFS(board, x, y - 1);
            if (x < board[0].length - 1)
                BFS(board, x, y + 1);
        }
    }

    public static void main(String[] args) {
        SurroundedRegion sr = new SurroundedRegion();
        char[][] board = {"OO".toCharArray(), "OO".toCharArray()};// "XXXX".toCharArray(), "XOOX".toCharArray(), "XOOX".toCharArray(), "XOXX".toCharArray() };
        sr.solve(board);
    }

}
