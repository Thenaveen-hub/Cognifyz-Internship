import java.util.Scanner;

public class TicTacToe {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY = '-';
    private static final char[] PLAYERS = {'X', 'O'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
        int currentPlayerIndex = 0;
        while (true) {
            printBoard(board);
            char currentPlayer = PLAYERS[currentPlayerIndex];
            System.out.printf("%s's turn. Enter row and column (1-3): ", currentPlayer);
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            while (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE || board[row][col] != EMPTY) {
                System.out.println("Invalid move. Try again.");
                System.out.printf("%s's turn. Enter row and column (1-3): ", currentPlayer);
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;
            }
            board[row][col] = currentPlayer;
            if (checkWin(board, currentPlayer)) {
                printBoard(board);
                System.out.printf("%s wins!\n", currentPlayer);
                break;
            } else if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("It's a tie!");
                break;
            }
            currentPlayerIndex = (currentPlayerIndex + 1) % PLAYERS.length;
        }
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
