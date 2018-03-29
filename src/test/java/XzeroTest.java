import org.junit.Test;
import ro.gabriel.oarga.Model.*;
import ro.gabriel.oarga.Service.XzeroAlgo;

public class XzeroTest {
    private Board board = new Board(3);
    private BoardElement[][] boardElement;

    @Test
    public void printBoardTest(){
        board.toString();
    }

    @Test
    public void addElementTest(){
        boardElement = board.getXzBoard();
        boardElement[1][1].setValue("O");
        printBoardTest();
    }

    @Test
    public void checkAlgo(){
        String state = "O";
        XzeroAlgo algo = new XzeroAlgo();

        boardElement = board.getXzBoard();
        boardElement[0][0].setValue("X");
        boardElement[0][1].setValue("O");
        boardElement[2][2].setValue("O");
        printBoardTest();

        algo.runAlgorithm(board.getXzBoard(), state);
        printBoardTest();
    }
}
