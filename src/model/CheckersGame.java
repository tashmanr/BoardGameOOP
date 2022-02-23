package model;

import io.DefaultIO;
import model.boards.CheckersBoard;

public class CheckersGame extends Game {
    public CheckersGame(DefaultIO dio) {
        super(dio);
        this.board = new CheckersBoard();
    }

}
