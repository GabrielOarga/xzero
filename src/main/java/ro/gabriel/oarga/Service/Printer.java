package ro.gabriel.oarga.Service;

import org.springframework.stereotype.Service;
import ro.gabriel.oarga.Model.BoardElement;

@Service
public class Printer {

    public String[] printBoard(BoardElement[][] board){
        String[] retur = new String[3];

        for (int i = 0; i < 3; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j].getValue());
            }
            retur[i] = sb.toString();
        }
        return retur;
    }
}
