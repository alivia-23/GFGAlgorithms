/**
 * Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:
 * Players take turns placing characters into empty squares ' '.
 * The first player A always places 'X' characters, while the second player B always places 'O' characters.
 * 'X' and 'O' characters are always placed into empty squares, never on filled ones.
 * The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli].
 * return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw".
 * If there are still movements to play return "Pending".
 * You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.
 *
 * Example 1:
 * Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
 * Output: "A"
 * Explanation: A wins, they always play first.
 *
 * Example 2:
 * Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
 * Output: "B"
 * Explanation: B wins.
 *
 * Example 3:
 * Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
 * Output: "Draw"
 * Explanation: The game ends in a draw since there are no moves to make.
 *
 */
public class TicTacToeGameWinner {

    private static char[][] board;
    private static int n = 3;

    public static String tictactoe(int[][] moves) {
        board = new char[n][n];
        String player = "A";
        boolean firstTurn = true;
        for (int[] move : moves) {
            int row = move[0];
            int col = move[1];
            if (firstTurn) {
                player = "A";
                board[row][col] = playerMove(player);
            } else {
                player = "B";
                board[row][col] = playerMove(player);
            }
            // check winning condition
            if (checkRow(row, player) || checkCol(col, player) || (row == col) && checkDiagonal(player) ||
                    (row + col) == n - 1 && checkAntiDiagonal(player)) {
                return playerMove(player) == 'X' ? "A" : "B";
            }
            firstTurn = !firstTurn;
        }
        return moves.length == n * n ? "Draw" : "Pending";
    }

    private static char playerMove(String player) {
        if (player == "A") {
            return 'X';
        } else {
            return 'O';
        }
    }

    private static boolean checkRow(int row, String player) {
        for (int col = 0; col < n; col++) {
            if (board[row][col] != playerMove(player)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCol(int col, String player) {
        for (int row = 0; row < n; row++) {
            if (board[row][col] != playerMove(player)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDiagonal(String player) {
        for (int row = 0; row < n; row++) {
            if (board[row][row] != playerMove(player)) {
                    return false;
            }
        }
        return true;
    }

    private static boolean checkAntiDiagonal(String player) {
        for (int row = 0; row < n; row++) {
            if (board[row][n - row - 1] != playerMove(player)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] moves = {{0,0}, {2,0}, {1,1}, {2,1}, {2,2}};
        int[][] moves1 = {{0,0}, {1,1}, {0,1}, {0,2}, {1,0}, {2,0}};
        System.out.println(tictactoe(moves));
        System.out.println(tictactoe(moves1));
    }

}
