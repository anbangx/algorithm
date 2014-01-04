package leetcode;

public class SudokuSolver {
    
    public void solveSudoku(char[][] board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(board == null || board.length == 0)
                return;
        dfs(board);
    }
    
    public boolean dfs(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(int k = 1; k <= 9; k++){
                        board[i][j] = (char) ('0' + k);
                        if(isValid(board, i, j) && dfs(board))
                            return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return false;
    }
    
    public boolean isValid(char[][] board, int x, int y){
        for(int i = 0; i < board.length; i++){
            if(i != x && board[i][y] == board[x][y])
                return false;
        }
        for(int j = 0; j < board[0].length; j++){
            if(j != y && board[x][j] == board[x][y])
                return false;
        }
        for (int i = 3 * (x / 3); i < 3 * (x / 3 + 1); i++){
            for (int j = 3 * (y / 3); j < 3 * (y / 3 + 1); j++){
                if (i != x && j != y && board[i][j] == board[x][y])
                    return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
