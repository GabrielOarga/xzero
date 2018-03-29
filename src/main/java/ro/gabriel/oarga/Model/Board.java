package ro.gabriel.oarga.Model;

public class Board {
    private BoardElement[][] xzBoard;

    public Board(int size) {
        this.xzBoard = new BoardElement[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.xzBoard[i][j] = new BoardElement(i, j);
            }
        }
    }

    public BoardElement[][] getXzBoard() {
        return xzBoard;
    }

    public void setXzBoard(BoardElement[][] xzBoard) {
        this.xzBoard = xzBoard;
    }

    @Override
    public String toString() {
        System.out.print("\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j < 2) {
                    System.out.print(xzBoard[i][j].getValue() + "  ");
                }
                else{
                    System.out.println(xzBoard[i][j].getValue() + "\n");
                }
            }
        }
        return "";
    }
}
