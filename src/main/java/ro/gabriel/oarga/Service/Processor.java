package ro.gabriel.oarga.Service;

import org.springframework.stereotype.Service;
import ro.gabriel.oarga.Model.BoardElement;

@Service
public class Processor {

    public BoardElement[][] addToBoard(BoardElement[][] boardElements, String coordinates, String state){

        String[] co = coordinates.split("_");
        int x = Integer.parseInt(co[0]);
        int y = Integer.parseInt(co[1]);
        if (boardElements[x][y].getValue().equals("?")){
            boardElements[x][y].setValue(state);
        } else {
            //TODO Something relevant needs to happen here
            System.out.println("Non valid input");
        }
        return  boardElements;
    }
}
