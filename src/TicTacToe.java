import java.util.Scanner;

public class TicTacToe {

    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board [][] = new String[ROWS][COLS];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean validMoveX = false;
        boolean validMoveO = false;
        boolean gameDone = false;

        clearBoard();

        do {

            do {
                display();
                int xMoveRow = SafeInputs.getRangedInt(in, "What row would X like to place in? ", 1, 3);
                xMoveRow = xMoveRow - 1;
                int xMoveCol = SafeInputs.getRangedInt(in, "What column would X like to place in? ", 1, 3);
                xMoveCol = xMoveCol - 1;

                if (isValidMove(xMoveRow, xMoveCol) == false) {
                    validMoveX = false;
                    System.out.println("Invalid move.");
                } else {
                    validMoveX = true;
                    board[xMoveRow][xMoveCol] = "X";
                }

                if (gameDone == false) {
                    gameDone = isColWin();
                }
                if (gameDone == false) {
                    gameDone = isRowWin();
                }
                if (gameDone == false) {
                    gameDone = isDiagnalWin();
                }
                if (gameDone == false) {
                    gameDone = isTie();
                }

            } while (!validMoveX);


            if (gameDone == false) {
                do {
                    display();
                    int oMoveRow = SafeInputs.getRangedInt(in, "What row would O like to place in? ", 1, 3);
                    oMoveRow = oMoveRow - 1;
                    int oMoveCol = SafeInputs.getRangedInt(in, "What column would O like to place in? ", 1, 3);
                    oMoveCol = oMoveCol - 1;

                    if (isValidMove(oMoveRow, oMoveCol) == false) {
                        validMoveO = false;
                        System.out.println("Invalid move.");
                    } else {
                        validMoveO = true;
                        board[oMoveRow][oMoveCol] = "O";
                    }

                } while (!validMoveO);
            }

            if (gameDone == false) {
                gameDone = isColWin();
            }
            if (gameDone == false) {
                gameDone = isRowWin();
            }
            if (gameDone == false) {
                gameDone = isDiagnalWin();
            }
            if (gameDone == false) {
                gameDone = isTie();
            }

        } while (!gameDone);
    }


    private static void clearBoard() {

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = "";
            }
        }

    }

    private static void display() {

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (j == 2) {
                    System.out.print(board[i][j]);
                    System.out.println();
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
        }

    }

    private static boolean isValidMove(int row, int col) {

        if (board[row][col].equals("")) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean isColWin() {

        if (board[0][0] == "" && board[0][1] == "" && board[0][2] == "") {
            return false;
        }

        if (board[0][0] == "X") {
            if (board[1][0] == "X") {
                if (board[2][0] == "X") {
                    display();
                    System.out.println("X Wins!");
                    return true;
                }
            }
        }
        if (board[0][1] == "X") {
            if (board[1][1] == "X") {
                if (board[2][1] == "X") {
                    display();
                    System.out.println("X Wins!");
                    return true;
                }
            }
        }
        if (board[0][2] == "X") {
            if (board[1][2] == "X") {
                if (board[2][2] == "X") {
                    display();
                    System.out.println("X Wins!");
                    return true;
                }
            }
        }
        if (board[0][0] == "O") {
            if (board[1][0] == "O") {
                if (board[2][0] == "O") {
                    display();
                    System.out.println("O Wins!");
                    return true;
                }
            }
        }
        if (board[0][1] == "O") {
            if (board[1][1] == "O") {
                if (board[2][1] == "O") {
                    display();
                    System.out.println("O Wins!");
                    return true;
                }
            }
        }
        if (board[0][2] == "O") {
            if (board[1][2] == "O") {
                if (board[2][2] == "O") {
                    display();
                    System.out.println("O Wins!");
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isRowWin() {

        if (board[0][0] == "" && board[1][0] == "" && board[2][0] == "") {
            return false;
        }

        if (board[0][0] == "X") {
            if (board[0][1] == "X") {
                if (board[0][2] == "X") {
                    display();
                    System.out.println("X Wins!");
                    return true;
                }
            }
        }
        if (board[1][0] == "X") {
            if (board[1][1] == "X") {
                if (board[1][2] == "X") {
                    display();
                    System.out.println("X Wins!");
                    return true;
                }
            }
        }
        if (board[2][0] == "X") {
            if (board[2][1] == "X") {
                if (board[2][2] == "X") {
                    display();
                    System.out.println("X Wins!");
                    return true;
                }
            }
        }
        if (board[0][0] == "O") {
            if (board[0][1] == "O") {
                if (board[0][2] == "O") {
                    display();
                    System.out.println("O Wins!");
                    return true;
                }
            }
        }
        if (board[1][0] == "O") {
            if (board[1][1] == "O") {
                if (board[1][2] == "O") {
                    display();
                    System.out.println("O Wins!");
                    return true;
                }
            }
        }
        if (board[2][0] == "O") {
            if (board[2][1] == "O") {
                if (board[2][2] == "O") {
                    display();
                    System.out.println("O Wins!");
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isDiagnalWin() {

        if (board[0][0] == "" && board[0][2] == "")
            return false;

        if (board[0][0] == "X") {
            if (board[1][1] == "X") {
                if (board[2][2] == "X") {
                    display();
                    System.out.println("X Wins!");
                    return true;
                }
            }
        }
        if (board[0][2] == "X") {
            if (board[1][1] == "X") {
                if (board[2][0] == "X") {
                    display();
                    System.out.println("X Wins!");
                    return true;
                }
            }
        }
        if (board[0][0] == "O") {
            if (board[1][1] == "O") {
                if (board[2][2] == "O") {
                    display();
                    System.out.println("O Wins!");
                    return true;
                }
            }
        }
        if (board[0][2] == "O") {
            if (board[1][1] == "O") {
                if (board[2][0] == "O") {
                    display();
                    System.out.println("O Wins!");
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isTie() {

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j].equals("")) {
                    return false;
                }
            }
        }

        display();
        System.out.println("It's a tie!");
        return true;
    }

}