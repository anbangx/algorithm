package leetcode.word;


public class WordSearch {

    public boolean exist(char[][] board, String word) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // base case
        if (word.length() == 0 || word == null)
            return true;
        // general case
        int numRows = board.length;
        int numColumns = board[0].length;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (board[i][j] == word.charAt(0)) {
                    char[][] markedboard = new char[numRows][numColumns];
                    for (int p = 0; p < numRows; p++) {
                        for (int q = 0; q < numColumns; q++)
                            markedboard[p][q] = board[p][q];
                    }
                    markedboard[i][j] = '1';
                    if (BFS(i, j, markedboard, word.substring(1)))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean BFS(int startRow, int startColumn, char[][] board, String word) {
        // base case
        if (word.length() == 0 || word == null)
            return true;
        // general case
        int numRows = board.length;
        int numColumns = board[0].length;
        if (startRow - 1 >= 0 && board[startRow - 1][startColumn] == word.charAt(0)) {
            char[][] markedboard = new char[numRows][numColumns];
            for (int p = 0; p < numRows; p++) {
                for (int q = 0; q < numColumns; q++)
                    markedboard[p][q] = board[p][q];
            }
            markedboard[startRow - 1][startColumn] = '1';
            if (BFS(startRow - 1, startColumn, markedboard, word.substring(1)))
                return true;
        }
        if (startRow + 1 < numRows && board[startRow + 1][startColumn] == word.charAt(0)) {
            char[][] markedboard = new char[numRows][numColumns];
            for (int p = 0; p < numRows; p++) {
                for (int q = 0; q < numColumns; q++)
                    markedboard[p][q] = board[p][q];
            }
            markedboard[startRow + 1][startColumn] = '1';
            if (BFS(startRow + 1, startColumn, markedboard, word.substring(1)))
                return true;
        }
        if (startColumn - 1 >= 0 && board[startRow][startColumn - 1] == word.charAt(0)) {
            char[][] markedboard = new char[numRows][numColumns];
            for (int p = 0; p < numRows; p++) {
                for (int q = 0; q < numColumns; q++)
                    markedboard[p][q] = board[p][q];
            }
            markedboard[startRow][startColumn - 1] = '1';
            if (BFS(startRow, startColumn - 1, markedboard, word.substring(1)))
                return true;
        }
        if (startColumn + 1 < numColumns && board[startRow][startColumn + 1] == word.charAt(0)) {
            char[][] markedboard = new char[numRows][numColumns];
            for (int p = 0; p < numRows; p++) {
                for (int q = 0; q < numColumns; q++)
                    markedboard[p][q] = board[p][q];
            }
            markedboard[startRow][startColumn + 1] = '1';
            if (BFS(startRow, startColumn + 1, markedboard, word.substring(1)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board1 = { "ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray() };
        System.out.println(wordSearch.exist(board1, "ABCCED"));
        char[][] board2 = { "ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray() };
        System.out.println(wordSearch.exist(board2, "SEE"));
        char[][] board3 = { "ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray() };
        System.out.println(wordSearch.exist(board3, "ABCB"));
        char[][] board4 = { "AB".toCharArray(), "CD".toCharArray() };
        System.out.println(wordSearch.exist(board4, "ABCD"));
        char[][] board5 = { "CAA".toCharArray(), "AAA".toCharArray(), "BCD".toCharArray() };
        System.out.println(wordSearch.exist(board5, "AAB"));
        char[][] board6 = { "ABCE".toCharArray(), "SFES".toCharArray(), "ADEE".toCharArray() };
        System.out.println(wordSearch.exist(board6, "ABCESEEEFS"));
    }

}
