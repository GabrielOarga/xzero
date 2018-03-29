package ro.gabriel.oarga.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ro.gabriel.oarga.Model.Board;
import ro.gabriel.oarga.Model.BoardElement;
import ro.gabriel.oarga.Service.Printer;
import ro.gabriel.oarga.Service.Processor;
import ro.gabriel.oarga.Service.XzeroAlgo;

@RestController
public class IndexController {
    private Board board = new Board(3);
    private BoardElement[][] boardElements = board.getXzBoard();

    @Autowired
    XzeroAlgo xzeroAlgo;

    @Autowired
    Processor processor;

    @Autowired
    Printer printer;

    @RequestMapping(value = "/")
    public RedirectView redirectSlash(){
        return new RedirectView("/map");
    }

    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String[] printShit(){
        return  printer.printBoard(boardElements);
    }

    @RequestMapping(value = "/play", method = RequestMethod.GET)
    public RedirectView getTheShit(@RequestParam(value = "next") String next){

        String state = "O";
        boardElements = processor.addToBoard(boardElements, next, state);
        if (xzeroAlgo.checkWinConditions(boardElements, "O")){
            return new RedirectView("/playerVictory");
        } else if(xzeroAlgo.checkFill(boardElements)){
            return new RedirectView("/tie");
        }
        boardElements = xzeroAlgo.runAlgorithm(boardElements, state);
        if (xzeroAlgo.checkWinConditions(boardElements, "X")){
            return new RedirectView("/aiVictory");
        } else if(xzeroAlgo.checkFill(boardElements)){
            return new RedirectView("/tie");
        }
        this.board.setXzBoard(boardElements);
        return new RedirectView("/map");
    }

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public RedirectView resetTheShit(){

        board = new Board(3);
        boardElements = board.getXzBoard();
        return new RedirectView("/map");
    }

    @RequestMapping(value = "/tie")
    public String printTie(){
        return "A Tie has occured!";
    }

    @RequestMapping(value = "/playerVictory")
    public String printPlayer(){
        return "Congratulations you have won!";
    }

    @RequestMapping(value = "/aiVictory")
    public String printAi(){
        return "You have lost to my creation!";
    }
}
