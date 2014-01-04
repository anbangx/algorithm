package leetcode;

public class ValidSudoko {
    
    public boolean isValidSudoku(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(board.length == 0) 
            return false;
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                row[i][j] = false;
                column[i][j] = false;
                block[i][j] = false;
            }
        }
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')
                    continue;
                int c = board[i][j] - '1'; 
                if(row[i][c] || column[j][c] || block[i+j/3][c])
                    return false;
                row[i][c] = column[j][c] = block[i+j/3][c] = true;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
