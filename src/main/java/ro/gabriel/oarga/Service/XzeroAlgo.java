package ro.gabriel.oarga.Service;

import org.springframework.stereotype.Service;
import ro.gabriel.oarga.Model.BoardElement;

@Service
public class XzeroAlgo {

    public BoardElement[][] runAlgorithm(BoardElement[][] board, String state){
        System.out.println("____________________");
        System.out.println("actually doing stuff");
        System.out.println("____________________\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getValue().equals("?")){
                    if (calcMove(board[i][j], board, state)){
                        writeValue(i, j, board, state);
                        return board;
                    }
                }
            }
        }
        writeRandomValue(board, state);
        System.out.println("printed in random position\n");
        return board;
    }

    public boolean checkWinConditions(BoardElement[][] board, String player){
        System.out.println("_______________________");
        System.out.println("checking win conditions");
        System.out.println("_______________________\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getValue().equals(player)){
                    if (calcMove(board[i][j], board, player)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkFill(BoardElement[][] board){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getValue().equals("?")){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean calcMove(BoardElement boardElement, BoardElement[][] board, String state) {
        int i = boardElement.getX();
        int j = boardElement.getY();

        for (int k = i - 1; k <= i + 1; k++) {
            if (k < 3 && k >= 0) {
                for (int l = j - 1; l <= j + 1; l++) {
                    if (l < 3 && l >= 0) {
                        if (i != k || j != l) {
                            if (checkForState(k, l, board, state)) {
                                if (checkForDepth(i, j, k, l, board, state)) {
                                    System.out.println("printed\n");
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("did not print\n");
        return false;
    }

    private void writeValue(int i,  int j, BoardElement[][] board, String state) {
        if (state.equals("X")){
            board[i][j].setValue("O");
        } else {
            board[i][j].setValue("X");
        }
    }

    private void writeRandomValue(BoardElement[][] board, String state) {
        //TODO It should try to find a reasonable place to put it
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Math.random() > 0.5) {
                    if (board[i][j].getValue().equals("?")) {
                        if (state.equals("X")) {
                            board[i][j].setValue("O");
                        } else {
                            board[i][j].setValue("X");
                        }
                        return;
                    }
                }
            }
        }
        writeRandomValue(board, state);
    }

    private boolean checkForState(int i, int j, BoardElement[][] board, String state) {
        return board[i][j].getValue().equals(state);
    }

    private boolean checkForDepth(int x, int y, int i, int j, BoardElement[][] board, String state) {
        System.out.print("x:" + x);
        System.out.print(" y:" + y);
        System.out.print(" i:" + i);
        System.out.print(" j:" + j);
        System.out.print("\n");
        if (x != i) {
            System.out.println("x!=i");
            if (y != j){
                System.out.println("+ y!=j");
                if (x == y && i == j){
                    System.out.println("+ x==y");
                    if (x < i) {
                        if (i + 1 < 3 && i + 1 >= 0) {
                            return board[i + 1][j + 1].getValue().equals(state);
                        } else {
                            return board[i - 2][j - 2].getValue().equals(state);
                        }
                    } else {
                        if (i - 1 < 3 && i - 1 >= 0) {
                            return board[i - 1][j - 1].getValue().equals(state);
                        } else {
                            return board[i + 2][j + 2].getValue().equals(state);
                        }
                    }
                } else if (x + y == 2){
                    System.out.println("+ x + y == 2");
                    if (x < i){
                        if (i + 1 < 3 && i + 1 >= 0) {
                            return board[i + 1][j - 1].getValue().equals(state);
                        } else {
                            return board[i - 2][j + 2].getValue().equals(state);
                        }
                    } else {
                        if (i - 1 < 3 && i - 1 >= 0) {
                            return board[i - 1][j + 1].getValue().equals(state);
                        } else {
                            return board[i + 2][j - 2].getValue().equals(state);
                        }
                    }
                } else {
                    System.out.println("false case");
                    return false;
                }
            } else {
                if (x < i){
                    if (i + 1 < 3 && i + 1 >= 0) {
                        return board[i + 1][j].getValue().equals(state);
                    } else {
                        return board[i - 2][j].getValue().equals(state);
                    }
                } else {
                    if (i - 1 < 3 && i - 1 >= 0) {
                        return board[i - 1][j].getValue().equals(state);
                    } else {
                        return board[i + 2][j].getValue().equals(state);
                    }
                }
            }
        } else {
            System.out.println("y != j");
            if (y < j){
                if (j + 1 < 3 && j + 1 >= 0) {
                    return board[i][j + 1].getValue().equals(state);
                } else {
                    return board[i][j - 2].getValue().equals(state);
                }
            } else {
                if (j - 1 < 3 && j - 1 >= 0) {
                    return board[i][j - 1].getValue().equals(state);
                } else {
                    return board[i][j + 2].getValue().equals(state);
                }
            }
        }
    }
}
